package com.spring.gameofthrones;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@SpringBootApplication
@Slf4j
public class GameOfThrones {

	public static void main(String[] args) {
		SpringApplication.run(GameOfThrones.class, args);
	}

}
