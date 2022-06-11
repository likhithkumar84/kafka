package com.spring.gameofthrones.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    public static final   String KAFKA_TOPIC = "my-first-topic";

    public void send(String message) {
        kafkaTemplate.send(KAFKA_TOPIC, message);
    }
}
