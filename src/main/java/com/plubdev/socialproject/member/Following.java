package com.plubdev.socialproject.member;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Following {
    @GeneratedValue @Id
    @Column(name = "following_id")
    private Long id;

    private LocalDateTime createdAt;
}
