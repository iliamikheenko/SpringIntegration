package com.example.springintegration.services;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MasterService {

    @Splitter(inputChannel = "inputChannel", outputChannel = "router")
    public List<Message<String>> splitArray(String[] input) {
        return Arrays.stream(input)
                .map(MessageBuilder::withPayload)
                .map(MessageBuilder::build)
                .toList();
    }

    @Router(inputChannel = "router")
    public String route(Message<String> message){
        var accessor = new IntegrationMessageHeaderAccessor(message);
        return accessor.getSequenceNumber()%2 == 0? "upperCaseConversion" : "reverseMessage";
    }

    @Aggregator(inputChannel = "aggregator", outputChannel = "replyChannel")
    public String[] aggregate(List<Message<String>> messages) {
        return messages.stream()
                .map(Message::getPayload)
                .toArray(String[]::new);
    }
}