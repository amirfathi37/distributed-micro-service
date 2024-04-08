package com.amigoscode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CusomerRepository repository;
    private final RestTemplate template;

    public void register(CustomerRegisterRequest registerRequest) {
        Customer customer = Customer.builder()
                .name(registerRequest.name())
                .family(registerRequest.family())
                .email(registerRequest.email())
                .build();
        //TODO : check if email is valid
        //TODO : check if email not taken
        repository.saveAndFlush(customer);
        FraudRespDto fraudRespDto = template.getForObject(
                "http://localhost:5000/api/v1/fraud-check/{ciustomerId}",
                FraudRespDto.class,
                customer.getId());
        if (fraudRespDto.isFraudster())
            throw new IllegalStateException("Fraudster!!!");
        //TODO : check if customer is fraudster
        //TODO : send notification
    }
}
