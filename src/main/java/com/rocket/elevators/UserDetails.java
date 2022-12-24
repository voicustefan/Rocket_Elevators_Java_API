package com.rocket.elevators;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserDetails {
    @JsonIgnore
    Collection<? extends GrantedAuthority> getAuthorities();

    @JsonIgnore
    String getPassword();

    String getUsername();

    @JsonIgnore
    boolean isAccountNonExpired();

    @JsonIgnore
    boolean isAccountNonLocked();

    @JsonIgnore
    boolean isCredentialsNonExpired();

    @JsonIgnore
    boolean isEnabled();
}
