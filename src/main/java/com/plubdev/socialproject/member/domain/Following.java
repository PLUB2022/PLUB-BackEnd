package com.plubdev.socialproject.member.domain;

import com.plubdev.socialproject.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Following {
    @GeneratedValue @Id
    @Column(name = "following_id")
    private Long id;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
