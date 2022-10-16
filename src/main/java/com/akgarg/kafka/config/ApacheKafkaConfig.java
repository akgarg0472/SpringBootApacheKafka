package com.akgarg.kafka.config;

import com.akgarg.kafka.enums.KafkaTopics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@Configuration
public class ApacheKafkaConfig {

    @Bean
    public NewTopic kafkaTopic() {
        final String topicName = KafkaTopics
                .APACHE_KAFKA.getTopicName();

        return TopicBuilder.name(topicName).build();
    }

}
