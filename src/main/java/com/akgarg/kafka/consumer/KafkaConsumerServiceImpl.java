package com.akgarg.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@Service
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);

    @Override
    @KafkaListener(topics = "apache-kafka", groupId = "consumerGroupId")
    public void consume(ConsumerRecord<String, Object> message) {
        LOGGER.info("Message received: {}", message.value());
    }

}
