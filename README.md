# Kafka Documentation:

* ### Create Topic
`docker exec kafka-broker kafka-topics --bootstrap-server kafka:19092 --create --topic my-first-topic
`
* ### Producer
`docker exec -it kafka-broker kafka-console-producer --bootstrap-server kafka:19092 --topic my-first-topic
`
* ### Consumer
`docker exec -it kafka-broker kafka-console-consumer --bootstrap-server kafka:19092 --topic my-first-topic
`
# Kafka setup locally:

### create a directory for logs:

`zookeeper.properties --> dataDir=C:/kafka/zookeeper-data && audit.enable=true`

`server.properties    --> log.dirs=C:/kafka/kafka-logs`


### start from:

`cd C:\kafka_2.13-3.2.0`

### cmd to start zookeeper:

`zookeeper-server-start config\zookeeper.properties`

### cmd to start kafka:

`kafka-server-start config\server.properties`

## Create Topic:

`kafka-topics --bootstrap-server localhost:9092 --create --topic STREAM.AMPM.FCT.OUTPUT-FLAG-EVENT.0 --replication-factor 1 --partitions 3`

## View Topic:

`kafka-topics --bootstrap-server localhost:9092 --list`

## Describe Topic:

`kafka-topics  --bootstrap-server localhost:9092 --describe --topic STREAM.AMPM.FCT.OUTPUT-FLAG-EVENT.0`

## Delete Topic

`kafka-topics --bootstrap-server localhost:9092 --delete --topic STREAM.AMPM.FCT.OUTPUT-FLAG-EVENT.0`

`--> delete.topic.enable = true`
## Producer:

`kafka-console-producer --topic STREAM.AMPM.FCT.OUTPUT-FLAG-EVENT.0 --bootstrap-server localhost:9092 --property parse.key=true --property key.separator=":"`

`-->key:Value`

## Consumer:

`kafka-console-consumer --topic STREAM.AMPM.FCT.OUTPUT-FLAG-EVENT.0 --bootstrap-server localhost:9092 --from-beginning --property print.key=true --property key.separator="-"`

`-->key-value`
