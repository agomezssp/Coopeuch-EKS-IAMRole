package com.htp.porvenir;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextCredentialsAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;


@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class, ContextCredentialsAutoConfiguration.class})
@Slf4j
public class PorvenirApplication {

	public static void main(String[] args) {
		SpringApplication.run(PorvenirApplication.class, args);
	}
}
