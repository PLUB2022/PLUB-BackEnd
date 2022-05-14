package com.plubdev.socialproject.global.oauth2.service;

import com.plubdev.socialproject.global.oauth2.LoginType;
import com.plubdev.socialproject.global.oauth2.authentication.AccessTokenLoginTypeToken;
import com.plubdev.socialproject.global.oauth2.authentication.OAuth2UserDetails;
import com.plubdev.socialproject.global.oauth2.service.strategy.LoginLoadStrategy;
import com.plubdev.socialproject.global.oauth2.service.strategy.NaverLoadStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoadUserService {

    private final RestTemplate restTemplate = new RestTemplate();
    private LoginLoadStrategy loginLoadStrategy;

    public OAuth2UserDetails getOAuth2UserDetails(AccessTokenLoginTypeToken authentication) {

        LoginType loginType = authentication.getLoginType();

        //LoginLoadStrategy 설정
        setLoginLoadStrategy(loginType);

        Map<String, Object> loginPk = loginLoadStrategy.getLoginPk(authentication.getAccessToken());
        String id = loginPk.get("id").toString();
        String gender = loginPk.get("gender").toString();
        String mobile = loginPk.get("mobile").toString();
        String age = loginPk.get("age").toString();
        String name = loginPk.get("name").toString();

        // Pk와 loginType을 통해 회원 생성
        return OAuth2UserDetails.builder()
                .loginId(id)
                .gender(gender)
                .phoneNumber(mobile)
                .username(name)
                .ageGroup(age)
                .loginType(loginType)
                .build();
    }

    private void setLoginLoadStrategy(LoginType loginType){
        this.loginLoadStrategy = new NaverLoadStrategy();
//        this.loginLoadStrategy = switch (loginType){
//
//            case KAKAO -> new KakaoLoadStrategy();
//            case GOOGLE ->  new GoogleLoadStrategy();
//            case NAVER ->  new NaverLoadStrategy();
//            default -> throw new IllegalArgumentException("지원하지 않는 로그인 형식입니다");
//        };
    }


}
