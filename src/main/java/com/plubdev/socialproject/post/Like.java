package com.plubdev.socialproject.post;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Like {

    @GeneratedValue @Id
    @Column(name = "like_id")
    private Long id;

    private LocalDateTime createdAt;
}
