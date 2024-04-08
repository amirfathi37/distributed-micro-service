package com.amigoscode.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudService(FraudRepository repository) {
    public Fraud save(Long customerId) {
        Fraud fraud = Fraud.builder()
                .customerId(customerId)
                .fraudster(Boolean.FALSE)
                .createAt(LocalDateTime.now())
                .build();
        return repository.save(fraud);
    }
}
