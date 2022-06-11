# Kafka Documentation:

* ### Create Topic
docker exec kafka-broker kafka-topics --bootstrap-server kafka:19092 --create --topic my-first-topic

* ### Producer
docker exec -it kafka-broker kafka-console-producer --bootstrap-server kafka:19092 --topic my-first-topic

* ### Consumer
docker exec -it kafka-broker kafka-console-consumer --bootstrap-server kafka:19092 --topic my-first-topic
