package roon.practice.sample.kafka.infra.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import roon.practice.sample.kafka.controller.dto.MessageDto;

@Slf4j
public class CustomSerializer implements Serializer<MessageDto> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		Serializer.super.configure(configs, isKey);
	}

	@Override
	public byte[] serialize(String topic, MessageDto data) {
		try {
			if (data == null) {
				log.error("null received at serializing");
				return null;
			}
			log.info("serializing...");
			return objectMapper.writeValueAsBytes(data);

		} catch (Exception e) {
			throw new SerializationException("Error when serializing MessageDto to byte[]");
		}
	}

	@Override
	public void close() {
		Serializer.super.close();
	}
}
