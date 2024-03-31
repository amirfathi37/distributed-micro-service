package com.amigoscode.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CusomerRepository repository) {
    public void register(CustomerRegisterRequest registerRequest) {
        Customer customer = Customer.builder()
                .name(registerRequest.name())
                .family(registerRequest.family())
                .address(registerRequest.email())
                .build();
        repository.save(customer);
    }
}
