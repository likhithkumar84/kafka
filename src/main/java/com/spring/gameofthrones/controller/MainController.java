package com.spring.gameofthrones.controller;

import com.spring.gameofthrones.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main Controller
 */
@RestController
@AllArgsConstructor
@Slf4j
public class MainController {

    KafkaProducer kafkaProducer;

    @GetMapping("gameOfThrones")
    public ResponseEntity<String> gameOfThrones(){

        kafkaProducer.send("Hello");
        log.info("Inside Controller");
        return ResponseEntity.ok("Sent Message to Kafka");
    }
}
