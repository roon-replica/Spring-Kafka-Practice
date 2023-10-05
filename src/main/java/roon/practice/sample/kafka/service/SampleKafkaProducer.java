package roon.practice.sample.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import roon.practice.sample.kafka.controller.dto.MessageDto;

@Slf4j
@Service
public class SampleKafkaProducer {

	private static final String TOPIC = "sample-topic";
	private final KafkaTemplate<String, MessageDto> kafkaTemplate;

	public SampleKafkaProducer(KafkaTemplate<String, MessageDto> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(MessageDto message) {
		log.info("produce message " + message);
		kafkaTemplate.send(TOPIC, message);
	}

}
