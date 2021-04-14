package com.htp.porvenir;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;



@Slf4j
public class SqsWriteComponent {


    private final QueueMessagingTemplate queueMessagingTemplate;

    private final MongoConnectComponent mongoConnectComponent;

    @Value("${app.queue.out.name}")
    private String outQueue;

    @Autowired
    public SqsWriteComponent(AmazonSQSAsync amazonSQSAsync, MongoConnectComponent mongoConnectComponent) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
        this.mongoConnectComponent = mongoConnectComponent;
    }

    public void send(String message) {
        if (message == null) {
            log.warn("SQS Producer cant produce 'null' value");
            return;
        }

        log.info("Mongo DB");
        mongoConnectComponent.TestMongo();

        log.info(" Message {} " + message);
        log.info(" Queue name {} " + outQueue);

        queueMessagingTemplate.send(outQueue, MessageBuilder.withPayload(message).build());
    }

}