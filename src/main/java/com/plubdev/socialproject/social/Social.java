package com.plubdev.socialproject.social;

import com.plubdev.socialproject.member.domain.Member;
import com.plubdev.socialproject.member.domain.MemberSocial;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Social {

    @GeneratedValue @Id
    @Column(name = "social_id")
    private Long id;

    private String title;
    private String content;

    private LocalDateTime createdAt;

    private String socialDate;
    private String socialTime;
    private String socialPeopleCount;

    private String entryFee;

    private String nthTime;

    @Enumerated(EnumType.STRING)
    private OnOffType onOffType;

    private boolean firstCome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "social", cascade = CascadeType.ALL)
    private List<MemberSocial> memberSocialList = new ArrayList<>();

    @OneToMany(mappedBy = "social", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "social", cascade = CascadeType.ALL)
    private List<SocialCategory> socialCategoryList = new ArrayList<>();

}
