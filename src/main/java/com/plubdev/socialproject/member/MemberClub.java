package com.plubdev.socialproject.member;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class MemberClub {

    @GeneratedValue @Id
    @Column(name = "member_club_id")
    private Long id;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ClubType clubType;
}
