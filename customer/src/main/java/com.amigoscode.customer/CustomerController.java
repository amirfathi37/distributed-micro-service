package com.amigoscode.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/cusomers")
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegisterRequest registerRequest) {
        log.info("request has been received for {}", registerRequest.email());
        customerService.register(registerRequest);
    }

    @GetMapping(path = "{family}")
    public List<CustomerRegisterResp> fetchCustomerByFamily(@PathVariable String family) {
        log.info("inquiry request has been received for {}", family);
        List<CustomerRegisterResp> resps = customerService.fetchCustomerByFamily(family);
        log.info("inquiry was successful {}", resps.toString());
        return resps;
    }

}
