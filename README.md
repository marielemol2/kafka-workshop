# kafka-workshop
El caso de uso creado para este workshop consiste en la creación de un tweet.
- Producer: cuando un usuario publique un tweet el microservicio va a producir un evento en topic 'tweet'.
- Consumer: va a consumir el tweet y va a generar un log.

Se va a utilizar la herramienta Docker Compose para generar y orquestrar los contenedores del consumer, producer, y zookeeper. 
También se ha definido un contenedor que inicializa los topics.


## Usage

```bash
docker compose up
```

```bash
mvn package
docker-compose build --no-cache && docker-compose up
```
