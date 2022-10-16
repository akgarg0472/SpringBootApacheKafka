package com.akgarg.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@Service
@RequiredArgsConstructor
public class KafkaJsonProducerService implements KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducerService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public boolean produce(final String topic, final Object message) {
        LOGGER.info("Producing message: {} in topic: {}", message, topic);

        try {
            Message<Object> _message = MessageBuilder
                    .withPayload(message)
                    .setHeader(KafkaHeaders.TOPIC, topic)
                    .build();

            this.kafkaTemplate.send(_message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
