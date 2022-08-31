package com.spring.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.demo.pojo.TaskStatus;
import com.spring.demo.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main Controller
 */
@RestController
@AllArgsConstructor
@Slf4j
public class MainController {

    public static final String KAFKA_TOPIC = "GAME.OF.THRONES";
    KafkaProducer kafkaProducer;
    ObjectMapper mapper;

    @PostMapping("gameOfThrones")
    public ResponseEntity<String> gameOfThrones(@RequestBody TaskStatus taskStatus) throws JsonProcessingException {

        String message = mapper.writeValueAsString(taskStatus);
        kafkaProducer.send(KAFKA_TOPIC, message);

        return ResponseEntity.ok("Sent Message to Kafka");
    }
}
