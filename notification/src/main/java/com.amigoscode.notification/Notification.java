package com.amigoscode.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence")
    private Integer id;
    private String message;
    private String Sender;
    private Date sebtAt;
    private String toCustomerEmail;
    private Long toCustomerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String text) {
        this.message = text;
    }

    public Long getToCustomerId() {
        return toCustomerId;
    }

    public void setToCustomerId(Long customerId) {
        this.toCustomerId = customerId;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public Date getSebtAt() {
        return sebtAt;
    }

    public void setSebtAt(Date sebtAt) {
        this.sebtAt = sebtAt;
    }

    public String getToCustomerEmail() {
        return toCustomerEmail;
    }

    public void setToCustomerEmail(String toCustomerEmail) {
        this.toCustomerEmail = toCustomerEmail;
    }
}
