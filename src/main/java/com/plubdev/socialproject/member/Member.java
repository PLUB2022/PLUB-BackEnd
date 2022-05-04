package com.plubdev.socialproject.member;

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
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String phoneNumber;
    private String gender;

    @ElementCollection
    private List<String> taste = new ArrayList<>();

    private LocalDateTime createdAt;

    private String memberDate;
    private String description;

}
