package com.akgarg.kafka.exception;

import com.akgarg.kafka.model.response.ApiErrorResponse;
import org.apache.kafka.common.errors.InvalidTopicException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception e) {
        final var errorResponse = new ApiErrorResponse();
        var message = "Internal server error";
        var status = 500;

        if (e instanceof HttpMessageNotReadableException) {
            message = "Invalid input";
            status = 400;
        } else if (e instanceof InvalidTopicException) {
            message = "Invalid Kafka topic";
            status = 400;
        }

        errorResponse.setMessage(message);
        errorResponse.setStatus(status);

        return ResponseEntity.status(status).body(errorResponse);
    }

}
