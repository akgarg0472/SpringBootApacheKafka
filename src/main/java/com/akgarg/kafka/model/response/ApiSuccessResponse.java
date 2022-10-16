package com.akgarg.kafka.model.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@Data
public class ApiSuccessResponse implements Serializable, ApiResponse {

    @Serial
    private static final long serialVersionUID = -27864738459L;

    private String message;
    private Object data;
    private int status;

}
