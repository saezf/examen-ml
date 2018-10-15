# Examen Mercadolibre
 
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. 
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

## Sobre el algoritmo
Se ha desarrollado el siguiente método ``` boolean isMutant(String[] dna) ``` que analiza una secuencia de ácido nucleico dada dentro de una molécula de ADN para determinar si el ADN es mutante.  
Como único parámetro de entrada se recibe un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN.  
Las letras que componen cada String solo pueden ser: ATCG. Las cuales representan cada base nitrogenada del ADN (**A**denina, **T**imina, **C**itosina y **G**uanina).  
El ADN es mutante (devuelve *true*), si se encuentra más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical. En caso contrario el ADN es humano (devuelve *false*).

## Sobre la API REST
Se ha implementado el algoritmo en un servicio web RESTful que permite analizar y registrar secuencias ADN como así también obtener estadísticas sobre las muestras analizadas.  
El proyecto está desarrollado completamente en JAVA 8 y utiliza Jetty como contenedor de Servlets y servidor web HTTP.  
El servicio web se encuentra alojado en Amazon Web Services (capa gratuita), haciendo uso de las siguientes tecnologías:
+ DynamoDB como base de datos no relacional.
+ API Gateway y Lambda para realizar las peticiones a la base de datos mediante HTTP.
+ ElastiCache (Redis) como almacén de datos clave-valor, en memoria.
+ Elastic Beanstalk para administrar la infraestructura, la cual consiste en instancias EC2 con balanceadores de carga.

### Para detectar mutantes
Para detectar si un humano es mutante debe enviar la secuencia de ADN mediante un HTTP POST con un JSON el cual tenga el siguiente formato: 
```
POST → /mutant
{
   "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
En caso de verificar un mutante, devuelve HTTP 200-OK, en caso contrario 403-Forbidden.

### Para obtener estadísticas
Todas las muestras obtenidas mediante el servicio web se almacenan en una base de datos (1 registro por ADN).  
Puede obtener estadísticas de las cadenas de ADN verificadas mediante un HTTP GET.
Se retorna un JSON con el siguiente formato:
```
GET → /stats
{
    "countMutant": 40,
    "countHuman": 100,
    "ratio": 0.4
}
```
