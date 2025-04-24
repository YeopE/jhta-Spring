package com.example.test18_miniproject.security;

import com.example.test18_miniproject.dto.Member1DTO;
import com.example.test18_miniproject.entity.Member1;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private Member1 member1;

    public CustomUserDetails(Member1 member1){
        this.member1=member1;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member1.getRole()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return member1.getPwd();
    }

    @Override
    public String getUsername() {
        return member1.getId();
    }
}
