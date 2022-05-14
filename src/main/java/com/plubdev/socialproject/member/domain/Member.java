package com.plubdev.socialproject.member.domain;

import com.plubdev.socialproject.club.Club;
import com.plubdev.socialproject.global.oauth2.LoginType;
import com.plubdev.socialproject.notification.Notification;
import com.plubdev.socialproject.post.Comment;
import com.plubdev.socialproject.post.Like;
import com.plubdev.socialproject.post.Post;
import com.plubdev.socialproject.social.Social;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String phoneNumber;
    private String gender;
    private String email;
    private String ageGroup;
    private String memberDate;
    private String memberYear;
    private String loginId;

    @ElementCollection
    private List<String> taste = new ArrayList<>();

    private LocalDateTime createdAt;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberSocial> memberSocialList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Social> socials = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberCategory> memberCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Club> clubs = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberClub> memberClubList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Follower> followerList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Following> followingList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();

    @Builder
    public Member(String name, String phoneNumber, String gender, String email, String ageGroup, String memberDate, String memberYear, String loginId, LoginType loginType, Role role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.ageGroup = ageGroup;
        this.memberDate = memberDate;
        this.memberYear = memberYear;
        this.loginId = loginId;
        this.loginType = loginType;
        this.role = role;
    }

//    @Builder
//    public Member(String loginId, LoginType loginType,  Role role) {
//        this.loginId = loginId;
//        this.loginType = loginType;
//        this.role = role;
//    }
}
