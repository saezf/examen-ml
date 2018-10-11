package tk.juanfrasaez.ml;

import static org.asynchttpclient.Dsl.asyncHttpClient;
import static org.eclipse.jetty.http.HttpStatus.BAD_REQUEST_400;
import static org.eclipse.jetty.http.HttpStatus.FORBIDDEN_403;
import static spark.Spark.*;

import org.asynchttpclient.AsyncHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tk.juanfrasaez.ml.model.dto.*;
import tk.juanfrasaez.ml.service.DNASequencing;

import com.google.gson.Gson;

import java.io.IOException;

public class Main {
    private static final String HUMAN = "human";
    private static final String MUTANT = "mutant";
    private static final String REDIS_SRV = System.getenv("REDIS_SRV");
    private static final String DB_API = System.getenv("DB_API");

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        final Gson gson = new Gson();
        final DNASequencing service = new DNASequencing();
        final JedisPool jedisPool = new JedisPool(REDIS_SRV);
        final AsyncHttpClient asyncHttpClient = asyncHttpClient();

        before((request, response) -> {
            response.type("application/json");
            response.header("Server", "X-Men Server 1.0");
        });

        get("/stats", (request, response) -> {
            Stats stats = new Stats();
            stats.setCountMutant(gson.fromJson(asyncHttpClient.prepareGet(DB_API + "/" + MUTANT).execute().get()
                    .getResponseBody(), DBStats.class).getStats());
            stats.setCountHuman(gson.fromJson(asyncHttpClient.prepareGet(DB_API + "/" + HUMAN).execute().get()
                    .getResponseBody(), DBStats.class).getStats());
            stats.calculateRatio();
            return stats;
        }, gson::toJson);

        post("/mutant", (request, response) -> {
            Sample sample = gson.fromJson(request.body(), Sample.class);
            DBSample dbSample = new DBSample(sample.toString());
            String species;
            try (Jedis jedis = jedisPool.getResource()) {
                species = jedis.get(dbSample.getDna());
                if (species == null) {
                    species = service.isMutant(sample.getDna()) ? MUTANT : HUMAN;
                    jedis.set(dbSample.getDna(), species);
                    asyncHttpClient.preparePost(DB_API + "/sample/" + species)
                            .setHeader("Content-Type", "application/json")
                            .setBody(gson.toJson(dbSample))
                            .execute();
                }
            }
            if (HUMAN.equals(species))
                halt(FORBIDDEN_403);
            return "";
        });

        exception(IllegalArgumentException.class, (exception, request, response) -> response.status(BAD_REQUEST_400));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting down application...");
            try {
                asyncHttpClient.close();
                jedisPool.close();
            } catch (IOException e) {
                logger.error("Error closing AsyncHttpClient", e);
            }
        }));
    }
}
