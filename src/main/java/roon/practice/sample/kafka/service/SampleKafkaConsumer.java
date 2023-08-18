package roon.practice.sample.kafka.service;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleKafkaConsumer {

	@KafkaListener(topics = "sample-topic", groupId = "kafka-sample")
	public void consume(String message) throws IOException {
		log.info("consumed message = " + message);
	}

}
