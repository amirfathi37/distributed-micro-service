package com.amigoscode.customer;

import com.amigoscode.client.fraud.FraudClient;
import com.amigoscode.client.fraud.FraudRespDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CusomerRepository repository;
    private final RestTemplate template;
    private final FraudClient fraudClient;


    public void register(CustomerRegisterRequest registerRequest) {
        Customer customer = Customer.builder()
                .name(registerRequest.name())
                .family(registerRequest.family())
                .email(registerRequest.email())
                .build();
        //TODO : check if email is valid
        //TODO : check if email not taken
        repository.saveAndFlush(customer);

        FraudRespDto fraudRespDto = fraudClient.checkFraudster(Long.valueOf(customer.getId()));
        if (fraudRespDto.isFraudster())
            throw new IllegalStateException("Fraudster!!!");
        //TODO : check if customer is fraudster
        //TODO : send notification
    }
}
