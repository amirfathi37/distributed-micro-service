package com.amigoscode.notification;

import com.amigoscode.client.notification.NotificationDTO;
import com.amigoscode.client.notification.NotificationRespDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class NotificationService {
    private final NotificationRepository repository;

    public NotificationRespDTO saveNotificationData(NotificationDTO dto) {
        Notification notification = Notification.builder()
                .message(dto.message())
                .toCustomerId(dto.customerId())
                .build();
        Notification savedNotification = repository.save(notification);
        return NotificationRespDTO.builder()
                .trackCode(Math.toIntExact(savedNotification.getId())).build();
    }
}
