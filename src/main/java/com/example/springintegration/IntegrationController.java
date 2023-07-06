package com.example.springintegration;

import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modify-array")
@RequiredArgsConstructor
@Validated
public class IntegrationController {
    private final IntegrationGateway integrationGateway;

    @GetMapping()
    public String[] getMessageFromIntegrationService(@RequestBody @NotEmpty String[] name){
        return integrationGateway.sendMessage(name);
    }
}