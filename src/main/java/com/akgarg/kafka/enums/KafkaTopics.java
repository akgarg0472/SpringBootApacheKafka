package com.akgarg.kafka.enums;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
public enum KafkaTopics {

    APACHE_KAFKA("apache-kafka");

    private final String topicName;

    KafkaTopics(final String topicName) {
        this.topicName = topicName;
    }

    public final String getTopicName() {
        return topicName;
    }

}
