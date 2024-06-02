package com.amigoscode.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.amigoscode.client")
public class NotoficationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotoficationApplication.class, args);
    }
}
