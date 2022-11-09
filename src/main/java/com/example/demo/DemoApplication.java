package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class DemoApplication {

	public DemoApplication(KafkaTemplate<String, String> producer) {
		this.producer = producer;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public final KafkaTemplate<String, String> producer;

	@EventListener(ApplicationStartedEvent.class)
	public void produce()	{
		producer.send("test", "hello world");
	}

	@KafkaListener(topics = {"test"}, groupId = "group_id")
	public void consume(ConsumerRecord<String, String> record) {
		System.out.println(record.key() + "___" + record.value());
	}
}
