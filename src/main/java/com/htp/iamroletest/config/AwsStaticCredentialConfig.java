package com.htp.iamroletest.config;


import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "use-role-type", havingValue = "AWSStaticCredentialsProvider")
@Slf4j
public class AwsStaticCredentialConfig {

    @Bean("AWSCredentialsProvider")
    @Primary
    public AWSCredentialsProvider getAwsStaticCredentialsProvider(
            @Value("${cloud.aws.credentials.accessKey}") String accessKey,
            @Value("${cloud.aws.credentials.secretKey}") String secretKey) {
        log.info("AWSCredentialsProvider=AWSStaticCredentialsProvider");
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
    }
}
