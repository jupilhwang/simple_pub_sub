package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
  private KafkaTemplate<Object, Object> kafkaTemplate;

  @Autowired
  public KafkaProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @EventListener(ApplicationStartedEvent.class)
  public void produce() {
    kafkaTemplate.send("test-json", new Customer("ghildong", "hong", 22));
  }
}
