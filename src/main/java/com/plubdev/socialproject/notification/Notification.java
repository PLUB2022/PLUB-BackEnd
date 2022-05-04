package com.plubdev.socialproject.notification;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Notification {

    @GeneratedValue @Id
    @Column(name = "notification_id")
    private Long id;

    private String message;
    private boolean readCheck;
    private LocalDateTime createdAt;
}
