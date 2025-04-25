package com.example.test18_miniproject.config;

import com.example.test18_miniproject.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //직접 보안 규칙을 정의
public class SecurityConfig {
    @Autowired
    CustomUserDetailService detailService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(httpSecurityCsrfConfigurer -> {
            httpSecurityCsrfConfigurer.disable(); //csrf 토큰값 사용안하기
        });

        http.authorizeHttpRequests(authz -> {
            authz.requestMatchers("/member/**").authenticated() // /member/** 요청경로는 인증된 사용자만 허용
                    .requestMatchers("/admin/**").hasAuthority("ADMIN") // /admin/** 요청경로는 ADMIN 권한이 없는 사용자만 허용
                    .anyRequest().permitAll(); //나머지 요청경로는 모든 권한 허용
        });

        http.formLogin(httpSecurityFormLoginConfigurer -> {
            httpSecurityFormLoginConfigurer
                    .usernameParameter("id")
                    .passwordParameter("pwd")
                    .loginPage("/login") //로그인페이지 경로 지정
                    .loginProcessingUrl("/loginOk") //로그인 처리 경로 지정(이 경로로 요청이 들어오면 스프링시큐리티가 인증처리) //디폴트값이 login 이라서 login.html에서 from 의 action이 login이면 따로 설정해주지 않아도 된다.
                    .defaultSuccessUrl("/",true) //로그인이 성공했을 때 이동할 페이지
                    .permitAll();
        });

        http.logout(httpSecurityLogoutConfigurer -> {
           httpSecurityLogoutConfigurer
                   .logoutUrl("/logout")
                   .logoutSuccessUrl("/");
        });

        http.userDetailsService(detailService);

        return http.build();
    }


}
