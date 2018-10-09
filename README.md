# Examen Mercadolibre
 
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. 
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

## Para detectar mutantes
Para detectar si un humano es mutante debe enviar la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el siguiente formato: 
```
POST → /mutant
{
   "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
En caso de verificar un mutante, devuelve HTTP 200-OK, en caso contrario 403-Forbidden.

## Para obtener estadísticas
Todas las muestras obtenidas mediante el servicio de deteción de mutantes se almacenan en una base de datos (1 registro por ADN).
Puede obtener estadísticas de las cadenas de ADN verificadas mediante un HTTP GET.
Se retorna un Json con el siguiente formato:
```
GET → /stats
{
    "countMutant": 40,
    "countHuman": 100,
    "ratio": 0.4
}
```
