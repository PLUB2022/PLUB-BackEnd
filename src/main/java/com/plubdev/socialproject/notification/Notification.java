package com.plubdev.socialproject.notification;

import com.plubdev.socialproject.member.Member;
import lombok.Getter;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
