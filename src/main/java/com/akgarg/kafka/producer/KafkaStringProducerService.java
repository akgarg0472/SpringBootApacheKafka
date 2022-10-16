package com.akgarg.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@Service
@AllArgsConstructor
public class KafkaStringProducerService implements KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public boolean produce(final String topic, final Object message) {
        LOGGER.info("Producing message {} in topic {}", message, topic);

        try {
            final String _message = this.objectMapper.writeValueAsString(message);
            this.kafkaTemplate.send(topic, _message);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return false;
    }

}
