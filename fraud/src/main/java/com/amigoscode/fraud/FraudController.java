package com.amigoscode.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
public record FraudController(FraudService fraudService) {
    @GetMapping(path = "{customerId}")
    public FraudRespDto checkFraudster(@PathVariable Long customerId) {
        Fraud saveFraud = fraudService.save(customerId);
        return new FraudRespDto(saveFraud.getFraudster());
    }
}
