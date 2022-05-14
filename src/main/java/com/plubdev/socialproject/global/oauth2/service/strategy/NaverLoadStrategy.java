package com.plubdev.socialproject.global.oauth2.service.strategy;

import com.plubdev.socialproject.global.oauth2.LoginType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Slf4j
public class NaverLoadStrategy extends LoginLoadStrategy{
    @Override
    protected Map<String, Object> sendRequestToLoginSite(HttpEntity request) {
        try {
            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    LoginType.NAVER.getUserInfoUrl(),
                    LoginType.NAVER.getMethod(),
                    request,
                    RESPONSE_TYPE);

            Map<String, Object> response2 = (Map<String, Object>) response.getBody().get("response");

            System.out.println("response2gender = " +   response2.get("gender").toString());
            System.out.println("response2mobile = " +   response2.get("mobile").toString());
            System.out.println("response2name = " +   response2.get("name").toString());
            System.out.println("response2age = " +   response2.get("age").toString());
            System.out.println("response2id = " +   response2.get("id").toString());
            return response2;

        } catch (Exception e) {
            log.error("AccessToken을 사용하여 NAVER 유저정보를 받아오던 중 예외가 발생했습니다 {}" ,e.getMessage() );
            throw e;
        }
    }
}
