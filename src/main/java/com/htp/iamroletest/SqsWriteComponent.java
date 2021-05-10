package com.htp.iamroletest;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class SqsWriteComponent {

    private final QueueMessagingTemplate queueMessagingTemplate;
    @Value("${app.queue.out.name}")

    private String outQueue;
    @Autowired

    public SqsWriteComponent(AmazonSQSAsync amazonSQSAsync) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public void send(String message) {
        if (message == null) {
            log.warn("SQS Producer cant produce 'null' value");
            return;
        }
        log.info(" Message {} " + message);
        log.info(" Queue name {} " + outQueue);

        Map<String, Object> headers = new HashMap<>();
        headers.put("message-group-id", "messageGroupId");
        headers.put("message-deduplication-id", "messageDeduplicationId");

        queueMessagingTemplate.convertAndSend(
                outQueue,
                MessageBuilder.withPayload(message).build(),
                headers
        );
    }

}