package com.htp.porvenir;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class SqsReadController {

    @SqsListener(value = "${app.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void loadMessageFromSQS( String message) {
        System.out.println(message);
    }




}
