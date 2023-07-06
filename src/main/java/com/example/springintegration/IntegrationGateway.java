package com.example.springintegration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = "inputChannel", replyChannel = "replyChannel")
    String[] sendMessage(String[] message);
}