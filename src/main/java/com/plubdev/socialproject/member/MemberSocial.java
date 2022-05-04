package com.plubdev.socialproject.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSocial {

    @Id @GeneratedValue
    private Long id;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;
}
