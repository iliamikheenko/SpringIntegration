package com.example.springintegration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {
    @Bean
    public MessageChannel inputChannel(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel router(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel reverseMessage(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel upperCaseConversion(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel aggregator(){
        return new DirectChannel();
    }
}