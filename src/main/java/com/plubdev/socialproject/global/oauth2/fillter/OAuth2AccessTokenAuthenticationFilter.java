package com.plubdev.socialproject.global.oauth2.fillter;

import com.plubdev.socialproject.global.oauth2.authentication.AccessTokenLoginTypeToken;
import com.plubdev.socialproject.global.oauth2.provider.AccessTokenAuthenticationProvider;
import com.plubdev.socialproject.global.oauth2.LoginType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
@Slf4j
public class OAuth2AccessTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    // /login/oauth2/ + ??? 오는 요청을 처리
    private static final String DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX = "/login/oauth2/";

    // GET 방식
    private static final String HTTP_METHOD = "GET";

    // AccessToken을 헤더에 보낼 때, 헤더의 key는 Authorization 이다.
    private static final String ACCESS_TOKEN_HEADER_NAME = "Authorization";

    // /login/oauth2/* , GET으로 온 요청에 매칭된다.
    private static final AntPathRequestMatcher DEFUALT_OAUTH2_LOGIN_PATH_REQUEST_MATCHER =
            new AntPathRequestMatcher(DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX + "*", HTTP_METHOD);

    public OAuth2AccessTokenAuthenticationFilter(AccessTokenAuthenticationProvider accessTokenAuthenticationProvider,
                                                 AuthenticationSuccessHandler authenticationSuccessHandler,
                                                 AuthenticationFailureHandler authenticationFailureHandler) {

        // /login/oauth2/* , GET으로 온 요청을 처리하기 위해 설정
        super(DEFUALT_OAUTH2_LOGIN_PATH_REQUEST_MATCHER);

        //AbstractAuthenticationProcessingFilter를 커스터마이징 하려면  ProviderManager를 꼭 지정해 주어야 한다(안그러면 예외)
        this.setAuthenticationManager(new ProviderManager(accessTokenAuthenticationProvider));
        this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        this.setAuthenticationFailureHandler(authenticationFailureHandler);

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        //AbstractAuthenticationProcessingFilter 의 추상 메서드를 구현한다. Authentication 객체를 반환해야 한다.

        //어떤 소셜 로그인을 할지 URL에서 추출
        LoginType loginType = extractLoginType(request);

        String accessToken = request.getHeader(ACCESS_TOKEN_HEADER_NAME);
        log.info("{}",loginType.getSocialName());
        log.info("{}",accessToken);

        //AuthenticationManager에게 인증 요청을 보낸다.
        // 이때 Authentication 객체로는 AccessTokenSocialTypeToken을(직접 커스텀 함) 사용한다.
        return this.getAuthenticationManager().authenticate(new AccessTokenLoginTypeToken(accessToken, loginType));
    }

    private LoginType extractLoginType(HttpServletRequest request) {
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        return Arrays.stream(LoginType.values())
                .filter(loginType ->
                        loginType.getSocialName()
                                .equals(request.getRequestURI().substring(DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX.length())))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 URL 주소입니다."));
    }
}
