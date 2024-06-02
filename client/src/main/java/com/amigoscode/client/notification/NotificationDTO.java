package com.amigoscode.client.notification;

import lombok.Builder;

@Builder
public record NotificationDTO(String message, String sender, String toCustomerEmail, Long customerId) {
}
