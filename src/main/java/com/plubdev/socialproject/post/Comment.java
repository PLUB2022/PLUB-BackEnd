package com.plubdev.socialproject.post;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {

    @GeneratedValue @Id
    @Column(name = "comment_id")
    private Long id;

    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
