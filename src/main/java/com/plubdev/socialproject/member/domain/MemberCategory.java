package com.plubdev.socialproject.member.domain;

import com.plubdev.socialproject.club.ClubCategory;
import com.plubdev.socialproject.member.domain.Member;
import com.plubdev.socialproject.social.CategoryOne;
import com.plubdev.socialproject.social.CategoryTwo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCategory {

    @Id @GeneratedValue
    @Column(name = "member_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category1_id")
    private CategoryOne categoryOne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category2_id")
    private CategoryTwo categoryTwo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_category_id")
    private ClubCategory clubCategory;

}
