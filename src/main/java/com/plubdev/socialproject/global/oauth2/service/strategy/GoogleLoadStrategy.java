//package com.plubdev.socialproject.global.oauth2.service.strategy;
//
//import com.plubdev.socialproject.global.oauth2.LoginType;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Map;
//@Slf4j
//public class GoogleLoadStrategy extends LoginLoadStrategy{
//
//    @Override
//    protected String sendRequestToLoginSite(HttpEntity request) {
//        try {
//            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(LoginType.GOOGLE.getUserInfoUrl(),
//                    LoginType.GOOGLE.getMethod(),
//                    request,
//                    RESPONSE_TYPE);
//
//            return (response.getBody().get("email")).toString();//구글은 email를 PK로 사용
//
//        } catch (Exception e) {
//            log.error("AccessToken을 사용하여 GOOGLE 유저정보를 받아오던 중 예외가 발생했습니다 {}" ,e.getMessage() );
//            throw e;
//        }
//    }
//}
