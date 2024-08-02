package com.isaachome.ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderAppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
