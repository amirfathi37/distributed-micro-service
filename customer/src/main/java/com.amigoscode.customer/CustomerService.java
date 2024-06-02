package com.amigoscode.customer;

import com.amigoscode.client.fraud.FraudClient;
import com.amigoscode.client.fraud.FraudRespDto;
import com.amigoscode.client.notification.NotificationDTO;
import com.amigoscode.client.notification.NotificatonClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CusomerRepository repository;
    private final FraudClient fraudClient;
    private final NotificatonClient notificatonClient;


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

//        notificatonClient.receiveNotification(NotificationDTO.builder()
//                        .customerId(Long.valueOf(customer.getId()))
//                        .toCustomerEmail("example@gmail.com")
//                        .message("example message")
//                        .sender("Admin")
//                        .build());
    }

    public List<CustomerRegisterResp> fetchCustomerByFamily(String family) {
        List<Customer> byFamilyLike = repository.getByFamilyLike(family);
        List<CustomerRegisterResp> resps = new ArrayList<>();
        byFamilyLike.stream()
                .forEach(c -> resps.add(new CustomerRegisterResp(c.getName(), c.getFamily(), c.getEmail())));
        return resps;
    }
}
