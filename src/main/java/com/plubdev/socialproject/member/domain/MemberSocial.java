package com.plubdev.socialproject.member.domain;

import com.plubdev.socialproject.social.Review;
import com.plubdev.socialproject.social.Social;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSocial {

    @Id @GeneratedValue
    @Column(name = "member_social_id")
    private Long id;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_id")
    private Social social;

    @OneToMany(mappedBy = "memberSocial", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
}
