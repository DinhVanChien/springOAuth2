package com.oauth2with_face_google.social;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.Collection;

public class SocialUserDetailsImpl implements SocialUserDetails {
    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
