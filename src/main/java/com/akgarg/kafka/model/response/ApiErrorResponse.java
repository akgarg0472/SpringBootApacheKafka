package com.akgarg.kafka.model.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@Data
public class ApiErrorResponse implements Serializable, ApiResponse {

    @Serial
    private static final long serialVersionUID = 27345376563475L;

    private String message;
    private int status;
    private List<String> errors;

}
