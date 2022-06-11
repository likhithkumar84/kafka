package com.spring.gameofthrones.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.spring.gameofthrones.producer.KafkaProducer.KAFKA_TOPIC;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-first-topic", groupId = "consumerRecord")
    public void getConsumer(ConsumerRecord<String,String> consumerRecord){
        log.info("Message: " + consumerRecord.value());
    }
}
