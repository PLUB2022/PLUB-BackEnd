package com.plubdev.socialproject.global.oauth2.authentication;

import com.plubdev.socialproject.global.oauth2.LoginType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class AccessTokenLoginTypeToken extends AbstractAuthenticationToken {

    private Object principal; //OAuth2UserDetails 타입
    private String accessToken;
    private LoginType loginType;

    public AccessTokenLoginTypeToken(String accessToken, LoginType loginType) {
        super(null);
        this.accessToken = accessToken;
        this.loginType = loginType;
        setAuthenticated(false);
    }

    @Builder
    public AccessTokenLoginTypeToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true); // must use super, as we override
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
