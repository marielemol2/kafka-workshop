# kafka-workshop
The use case created for this workshop is the creation of a tweet. 
- Producer: when a user publishes a tweet, the microservice will produce an event in topic 'tweet'.
- Consumer: consumes the tweet from the topic 'tweet' and generates a log.

Docker Compose tool is used to get microservices up and running easily. Along with microservices, Kafka broker and the zookeeper service are also needed.


## Usage
Create services that are described in the docker-compose.yml. 
```bash
docker-compose up
```
If the code of microservices is modified the .jar file must be generated, the services must be rebuilt without using the cache, and services must be recreated again.
```bash
mvn package
docker-compose build --no-cache && docker-compose up
```

