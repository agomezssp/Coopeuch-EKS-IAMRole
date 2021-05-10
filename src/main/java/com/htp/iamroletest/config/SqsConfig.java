package com.htp.iamroletest.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;
import com.amazonaws.services.sqs.buffered.QueueBufferConfig;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@EnableSqs
@Configuration
public class SqsConfig {

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync(AWSCredentialsProvider awsCredentialsProvider){
        AmazonSQSAsync amazonSQSAsync = AmazonSQSAsyncClientBuilder
                .standard()
                .withCredentials(awsCredentialsProvider)
                .build();

        QueueBufferConfig config = new QueueBufferConfig()
                .withMaxInflightReceiveBatches(8)
                .withMaxDoneReceiveBatches(10)
                .withLongPollWaitTimeoutSeconds(1)
                .withVisibilityTimeoutSeconds(30)
                ;

        return new AmazonSQSBufferedAsyncClient(amazonSQSAsync, config);
    }

}