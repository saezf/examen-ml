package tk.juanfrasaez.ml.model.dto;

import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("count_mutant_dna")
    private int countMutant;

    @SerializedName("count_human_dna")
    private int countHuman;

    private double ratio;

    public int getCountMutant() {
        return countMutant;
    }

    public void setCountMutant(int countMutant) {
        this.countMutant = countMutant;
    }

    public int getCountHuman() {
        return countHuman;
    }

    public void setCountHuman(int countHuman) {
        this.countHuman = countHuman;
    }

    public double getRatio() {
        return ratio;
    }

    public void calculateRatio() {
        this.ratio = countMutant > 0 ? (double) countMutant / countHuman : 1;
    }
}
