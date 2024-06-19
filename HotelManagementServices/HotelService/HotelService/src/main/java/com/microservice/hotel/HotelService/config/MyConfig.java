package com.microservice.hotel.HotelService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MyConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        return new RestTemplate();


    }
}
