package roon.practice.sample.kafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.sample.kafka.service.SampleKafkaProducer;

@RestController
@RequestMapping("/kafka-sample")
public class SampleKafkaController {

	private final SampleKafkaProducer producer;

	public SampleKafkaController(SampleKafkaProducer producer) {
		this.producer = producer;
	}

	@PostMapping
	public String sendMessage(@RequestBody String message) {
		producer.sendMessage(message);
		return "success";
	}
}
