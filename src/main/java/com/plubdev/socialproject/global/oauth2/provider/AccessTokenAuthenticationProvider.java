package com.plubdev.socialproject.global.oauth2.provider;

import com.plubdev.socialproject.global.oauth2.authentication.AccessTokenLoginTypeToken;
import com.plubdev.socialproject.global.oauth2.authentication.OAuth2UserDetails;
import com.plubdev.socialproject.global.oauth2.service.LoadUserService;
import com.plubdev.socialproject.member.domain.Member;
import com.plubdev.socialproject.member.domain.Role;
import com.plubdev.socialproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccessTokenAuthenticationProvider implements AuthenticationProvider {

    private final LoadUserService loadUserService; // AccessToken을 가지고 회원의 정보를 가져오는 역할
    private final MemberRepository memberRepository; // 받아온 정보를 통해 DB에 회원을 조회

    @SneakyThrows
    @Override
    //ProviderManager가 호출한다. 인증을 처리한다
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // OAuth2UserDetails는 UserDetails를 상속받아 구현한 클래스이다.
        // 이후 일반 회원가입 시 UserDetails를 사용하는 부분과의 다형성을 위해 이렇게 구현하였다.
        // getOAuth2UserDetails에서는 restTemplate과 AccessToken을 가지고 회원정보를 조회해온다 (식별자 값을 가져옴)
        OAuth2UserDetails oAuth2User = loadUserService.getOAuth2UserDetails((AccessTokenLoginTypeToken) authentication);

        Member member = saveOrGet(oAuth2User);//받아온 식별자 값과 social로그인 방식을 통해 회원을 DB에서 조회 후 없다면 새로 등록해주고, 있다면 그대로 반환한다.
        oAuth2User.setRoles(member.getRole().name());//우리의 Role의 name은 ADMIN, USER, GUEST로 ROLE_을 붙여주는 과정이 필요하다.

        log.info("{}",oAuth2User.getLoginId());
        log.info("{}",oAuth2User.getPhoneNumber());
        log.info("{}",oAuth2User.getGender());
        log.info("{}",oAuth2User.getAgeGroup());
        log.info("{}",member.getRole().name());

        return AccessTokenLoginTypeToken.builder().principal(oAuth2User).authorities(oAuth2User.getAuthorities()).build();
        //AccessTokenSocialTypeToken객체를 반환한다. principal은 OAuth2UserDetails객체이다. (formLogin에서는 UserDetails를 가져와서 결국 ContextHolder에 저장하기 때문에)
        //이렇게 구현하면 UserDetails 타입으로 회원의 정보를 어디서든 조회할 수 있다.
    }

    private Member saveOrGet(OAuth2UserDetails oAuth2User) {
        return memberRepository.findByLoginTypeAndLoginId(oAuth2User.getLoginType(), oAuth2User.getLoginId())
                .orElseGet(() -> memberRepository.save(Member.builder()
                        .loginId(oAuth2User.getLoginId())
                        .loginType(oAuth2User.getLoginType())
                        .phoneNumber(oAuth2User.getPhoneNumber())
                        .ageGroup(oAuth2User.getAgeGroup())
                        .name(oAuth2User.getUsername())
                        .gender(oAuth2User.getGender())
                        .role(Role.GUEST).build()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //AccessTokenSocialTypeToken타입의  authentication 객체이면 해당 Provider가 처리한다.
        return AccessTokenLoginTypeToken.class.isAssignableFrom(authentication);
    }
}
