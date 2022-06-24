package com.spring.gameofthrones.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    public static final   String KAFKA_TOPIC = "GAME.OF.THRONES";

    public void send(String message) {
        String uuidAsString = UUID.randomUUID().toString();
        kafkaTemplate.send(KAFKA_TOPIC,uuidAsString, message);
    }
}
