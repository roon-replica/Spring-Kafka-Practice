package roon.practice.sample.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import roon.practice.sample.kafka.controller.dto.MessageDto;

@Slf4j
@Service
public class SampleKafkaConsumer {

	// 같은 groupId는 리스너 둘 중에 하나만 수신해야 정상
	@KafkaListener(topics = "sample-topic", groupId = "kafka-sample")
	public void consume(MessageDto message) {
		log.info("consumed message = " + message);
	}

	@KafkaListener(topics = "sample-topic", groupId = "kafka-sample")
	public void consumeSameGroup(MessageDto message) {
		log.info("consumed message = " + message);
	}

	@KafkaListener(topics = "sample-topic", groupId = "kafka-sample2")
	public void consume2(MessageDto message) {
		log.info("consumed message2 = " + message);
	}

}
