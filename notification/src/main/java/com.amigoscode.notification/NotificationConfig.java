package com.amigoscode.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Value("${rabbitmq.exchange.internal}")
    private String internalExchange;
    @Value("${rabbitmq.queue.notification}")
    private String notificationqueue;
    @Value("${rabbitmq.routing-key.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationqueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with(this.internalNotificationRoutingKey);
    }

    public String getInternalExchange() {
        return internalExchange;
    }

    public String getNotificationqueue() {
        return notificationqueue;
    }

    public String getInternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }
}
