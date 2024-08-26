package com.amigoscode.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {
    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info("publishing to {} using routingKey{}. Payload: {}", exchange, routingKey, routingKey);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("published to {} using routingKey{}. Payload: {}", exchange, routingKey, routingKey);

    }

}
