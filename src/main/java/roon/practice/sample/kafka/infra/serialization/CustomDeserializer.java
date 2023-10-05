package roon.practice.sample.kafka.infra.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import roon.practice.sample.kafka.controller.dto.MessageDto;

@Slf4j
public class CustomDeserializer implements Deserializer<MessageDto> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public MessageDto deserialize(String topic, byte[] data) {
		try {
			if (data == null) {
				log.error("Null received at deserializing");
				return null;
			}
			log.info("Deserializing...");
			return objectMapper.readValue(new String(data, "UTF-8"), MessageDto.class);
		} catch (Exception e) {
			throw new SerializationException("Error when deserializing byte[] to MessageDto");
		}
	}

	@Override
	public void close() {
	}
}