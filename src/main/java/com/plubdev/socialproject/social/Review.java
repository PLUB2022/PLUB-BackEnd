package com.plubdev.socialproject.social;

import com.plubdev.socialproject.member.MemberSocial;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Review {

    @GeneratedValue @Id
    @Column(name = "review_id")
    private Long id;

    private String reviewTitle;
    private String reviewContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_social_id")
    private MemberSocial memberSocial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_id")
    private Social social;
}
