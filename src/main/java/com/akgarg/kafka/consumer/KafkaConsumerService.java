package com.akgarg.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
public interface KafkaConsumerService {

    void consume(ConsumerRecord<String, Object> message);

}
