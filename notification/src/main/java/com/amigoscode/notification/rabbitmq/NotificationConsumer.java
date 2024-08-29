package com.amigoscode.notification.rabbitmq;

import com.amigoscode.client.notification.NotificationDTO;
import com.amigoscode.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void getNotification(NotificationDTO notificationDTO) {
        log.info("received this notification: {}", notificationDTO);
        notificationService.saveNotificationData(notificationDTO);
    }
}
