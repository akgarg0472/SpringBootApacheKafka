package com.akgarg.kafka.producer;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
public interface KafkaProducerService {

    boolean produce(String topic, Object message);

}
