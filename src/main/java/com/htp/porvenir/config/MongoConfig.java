package com.htp.porvenir.config;


import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//    @Configuration
public class MongoConfig {

    private final MongoProperties mongoProperties;


    public MongoConfig(MongoProperties mongoProperties) {
        super();
        this.mongoProperties = mongoProperties;
    }


//        @Bean
//        public MongoClientOptions mongoClientOptions() {
//            return MongoClientOptions.builder().sslEnabled(true).build();
//        }

}
