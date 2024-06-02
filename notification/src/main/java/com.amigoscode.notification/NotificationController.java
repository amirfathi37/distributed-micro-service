package com.amigoscode.notification;

import com.amigoscode.client.notification.NotificationDTO;
import com.amigoscode.client.notification.NotificationRespDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@Data
public class NotificationController {
    private final NotificationService service;
    @PostMapping("/receive-notification")
    public NotificationRespDTO receiveNotification(@RequestBody NotificationDTO dto) {
        log.info("notification was sent...");
        return service.saveNotificationData(dto);
    }
}
