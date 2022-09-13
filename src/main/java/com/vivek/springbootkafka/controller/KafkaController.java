package com.vivek.springbootkafka.controller;

import com.vivek.springbootkafka.kafka.KafkaProducer;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private NewTopic topicName;

    //    mapping url : http:localhost:8080/kafka/health
    @GetMapping("/health")
    public ResponseEntity<String> healthState() {
        return new ResponseEntity<>("Server is running ", HttpStatus.ACCEPTED);
    }

    //    mapping url : http:localhost:8080/kafka/publish?message=hello vivek!
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(topicName.name(), message);
        return new ResponseEntity<>("Message Published to topic - " + topicName.name(), HttpStatus.OK);
    }
}
