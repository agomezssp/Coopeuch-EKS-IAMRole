package com.htp.iamroletest;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseConfiguration {


    @Bean
    public SqsWriteComponent sqsWriteComponent(AmazonSQSAsync amazonSQSAsync){
        return new SqsWriteComponent(amazonSQSAsync);
    }

    @Bean
    public SqsReadComponent sqsReadComponent(SqsWriteComponent sqsWriteComponent){
        return new SqsReadComponent(sqsWriteComponent);
    }
}
