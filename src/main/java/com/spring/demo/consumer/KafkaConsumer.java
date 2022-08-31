package com.spring.demo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.demo.pojo.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.spring.demo.controller.MainController.KAFKA_TOPIC;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    ObjectMapper mapper;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "consumerRecord")
    public void getConsumer(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {

        log.info(String.format("Consumer Record : %s", consumerRecord.value()));
        TaskStatus user = mapper.readValue(consumerRecord.value(), TaskStatus.class);
        log.info(String.format("Task Status : %s", user.toString()));
    }
}
