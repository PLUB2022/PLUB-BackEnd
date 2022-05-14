package com.plubdev.socialproject.member.domain;

import com.plubdev.socialproject.club.Club;
import com.plubdev.socialproject.member.domain.ClubType;
import com.plubdev.socialproject.member.domain.Member;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;
}
