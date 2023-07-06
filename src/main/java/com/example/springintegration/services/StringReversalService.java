package com.example.springintegration.services;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class StringReversalService {

    @Transformer(inputChannel = "reverseMessage", outputChannel = "aggregator")
    public String reverseMessage(String payload) {
        return new StringBuilder(payload).reverse().toString();
    }
}