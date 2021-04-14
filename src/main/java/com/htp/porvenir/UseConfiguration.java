package com.htp.porvenir;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseConfiguration {

    @Bean
    public MongoConnectComponent mongoConnectComponent(){
        return new MongoConnectComponent();
    }

    @Bean
    public SqsWriteComponent sqsWriteComponent(AmazonSQSAsync amazonSQSAsync, MongoConnectComponent mongoConnectComponent){
        return new SqsWriteComponent(amazonSQSAsync, mongoConnectComponent);
    }

    @Bean
    public SqsReadComponent sqsReadComponent(SqsWriteComponent sqsWriteComponent){
        return new SqsReadComponent(sqsWriteComponent);
    }
}
