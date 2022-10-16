package com.akgarg.kafka.model.request;

import lombok.Data;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@Data
public class StringProducerRequest {

    private String topic;
    private String message;

}
