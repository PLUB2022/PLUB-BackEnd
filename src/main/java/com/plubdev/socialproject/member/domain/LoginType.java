package com.plubdev.socialproject.member.domain;

import lombok.Getter;
import org.springframework.http.HttpMethod;

@Getter
public enum LoginType {
//    KAKAO(
//            "kakao",
//                    "https://kapi.kakao.com/v2/user/me",
//            HttpMethod.GET
//            ),
//
//    GOOGLE(
//            "google",
//                    "https://www.googleapis.com/oauth2/v3/userinfo",
//            HttpMethod.GET
//            ),

    NAVER(
            "naver",
                    "https://openapi.naver.com/v1/nid/me",
            HttpMethod.GET
            );



    private String socialName;
    private String userInfoUrl;
    private HttpMethod method;

    LoginType(String socialName, String userInfoUrl, HttpMethod method) {
        this.socialName = socialName;
        this.userInfoUrl = userInfoUrl;
        this.method = method;
    }
}