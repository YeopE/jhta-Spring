package com.example.test18_miniproject.security;

import com.example.test18_miniproject.entity.Member1;
import com.example.test18_miniproject.repository.Member1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private Member1Repository member1Repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member1 member1 = member1Repository.findById(username);
        if(member1 == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        UserDetails userDetails = new CustomUserDetails(member1);
        return userDetails;
    }
}
