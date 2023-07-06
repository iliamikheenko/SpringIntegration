package com.example.springintegration.services;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class UppercaseConversionService {

    @Transformer(inputChannel = "upperCaseConversion", outputChannel = "aggregator")
    public String upperMessage(String payload) {
        return payload.toUpperCase();
    }
}