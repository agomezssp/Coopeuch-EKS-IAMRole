package com.htp.porvenir.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.WebIdentityTokenCredentialsProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "use-role")
@Slf4j
public class AwsRoleCredentialConfig {

    @Bean("AWSCredentialsProvider")
    @Primary
    public AWSCredentialsProvider getAwsCredentialsProvider(Environment env) {
        log.info("AWSCredentialsProvider=WebIdentityTokenCredentialsProvider roleArn={}", env.getProperty("AWS_ROLE_ARN"));
        return WebIdentityTokenCredentialsProvider
                .builder()
                .roleArn(env.getProperty("AWS_ROLE_ARN"))
                .build();
    }

}
