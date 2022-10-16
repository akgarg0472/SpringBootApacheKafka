package com.akgarg.kafka.producer;

import com.akgarg.kafka.model.request.JsonProducerRequest;
import com.akgarg.kafka.model.request.StringProducerRequest;
import com.akgarg.kafka.model.response.ApiResponse;
import com.akgarg.kafka.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akhilesh Garg
 * @since 16-10-2022
 */
@RestController
@RequestMapping("/api/v1/kafka/produce")
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaProducerService kafkaStringProducerService;
    private final KafkaProducerService kafkaJsonProducerService;

    @PostMapping("/string")
    public ResponseEntity<ApiResponse> produceStringMessage(@RequestBody StringProducerRequest request) {
        final String topic = request.getTopic();
        final String message = request.getMessage();

        final boolean produceResult = this.kafkaStringProducerService.produce(topic, message);

        return Utility.generatePublishResponse(produceResult);
    }

    @PostMapping("/json")
    public ResponseEntity<ApiResponse> produceJsonMessage(@RequestBody JsonProducerRequest request) {
        final Object message = request.getMessage();
        final String topic = request.getTopic();

        final boolean produceResult = kafkaJsonProducerService.produce(topic, message);

        return Utility.generatePublishResponse(produceResult);
    }

}
