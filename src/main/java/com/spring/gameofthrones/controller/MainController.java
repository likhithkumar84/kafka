package com.spring.gameofthrones.controller;

import com.spring.gameofthrones.producer.KafkaProducer;
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

    KafkaProducer kafkaProducer;

    @PostMapping("gameOfThrones")
    public ResponseEntity<String> gameOfThrones(@RequestBody Object message) {

        kafkaProducer.send(message.toString());
        return ResponseEntity.ok("Sent Message to Kafka");
    }
}
