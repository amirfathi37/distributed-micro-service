package com.amigoscode.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificatonClient {
    @PostMapping(path = "/api/v1/receive-notification")
    NotificationRespDTO receiveNotification(@RequestBody NotificationDTO dto);
}
