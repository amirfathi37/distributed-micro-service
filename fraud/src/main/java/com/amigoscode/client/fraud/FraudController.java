package com.amigoscode.client.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public record FraudController(FraudService fraudService) {
    @GetMapping(path = "{customerId}")
    public FraudRespDto checkFraudster(@PathVariable Long customerId) {
        log.info("A request has been received for customer byy id: {}", customerId);
        Fraud saveFraud = fraudService.save(customerId);
        return new FraudRespDto(saveFraud.getFraudster());
    }
}
