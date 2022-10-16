package com.akgarg.kafka.utils;

import com.akgarg.kafka.model.response.ApiErrorResponse;
import com.akgarg.kafka.model.response.ApiResponse;
import com.akgarg.kafka.model.response.ApiSuccessResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
public class Utility {

    private Utility() {
    }

    public static ResponseEntity<ApiResponse> generatePublishResponse(final boolean produceResult) {
        if (produceResult) {
            final var successResponse = new ApiSuccessResponse();
            successResponse.setMessage("Message successfully published to kafka");
            successResponse.setStatus(200);
            return ResponseEntity.ok(successResponse);
        } else {
            final var errorResponse = new ApiErrorResponse();
            errorResponse.setStatus(500);
            errorResponse.setMessage("Error producing message");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

}
