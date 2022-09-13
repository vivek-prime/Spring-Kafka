package com.vivek.springbootkafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    //    we will use KafkaListener annotation to listen to the messages or events published to the topic
    @KafkaListener(topics = "kafka_learning", groupId = "ConsumerGroup")
    public void consume(String message) {
        log.info("Message consumed - {}", message);
    }
}
