package roon.practice.sample.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleKafkaProducer {

	private static final String TOPIC = "sample-topic";
	private final KafkaTemplate<String, String> kafkaTemplate;

	public SampleKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		log.info("produce message " + message);
		kafkaTemplate.send(TOPIC, message);
	}

}
