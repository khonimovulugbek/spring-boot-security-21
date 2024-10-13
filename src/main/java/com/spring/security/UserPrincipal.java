package com.spring.security;

import com.spring.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public record UserPrincipal(Users user) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> authorities = user.getAuthorities();
        if (authorities == null) authorities = new ArrayList<>();
        return authorities.stream()
                .filter(Objects::nonNull)
                .map(role -> new SimpleGrantedAuthority(
                role.startsWith("ROLE_") ? role : "ROLE_" + role
                ))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountExpiredDate() == null || user.getAccountExpiredDate().isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isBlocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsExpiredDate() == null || user.getCredentialsExpiredDate().isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isEnabled() {
        return user.isEnable();
    }
}
