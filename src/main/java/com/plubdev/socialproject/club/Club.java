package com.plubdev.socialproject.club;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Club {

    @GeneratedValue @Id
    @Column(name = "club_id")
    private Long id;

    private String title;
    private String content;

    private LocalDateTime createdAt;
    private String clubDate;
    private String clubTime;
    private String clubPeopleCount;
}
