package com.htp.porvenir;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;

import java.util.HashMap;

@Slf4j
public class SqsReadComponent {

    protected  SqsWriteComponent sqsWriteComponent;


    @Autowired
    public SqsReadComponent(SqsWriteComponent sqsWriteComponent) {
        this.sqsWriteComponent = sqsWriteComponent;
    }

    @SqsListener(value = "${app.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void loadMessageFromSQS( String message) {

        System.out.println(message);



        sqsWriteComponent.send(message);

    }




}
