package com.plubdev.socialproject.club;

import com.plubdev.socialproject.member.Member;
import com.plubdev.socialproject.member.MemberClub;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<MemberClub> memberClubList = new ArrayList<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<ClubCategory> clubCategoryList = new ArrayList<>();
}
