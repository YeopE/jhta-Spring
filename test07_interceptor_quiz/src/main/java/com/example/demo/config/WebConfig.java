package com.example.demo.config;

import com.example.demo.interceptor.AdminCheckInterceptor;
import com.example.demo.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/member/login","/member/logout","/css/**","/*.ico");

        registry.addInterceptor(new AdminCheckInterceptor())
                .order(2)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/member/login","/member/logout","/item/list1","/item/list2","/css/**","/*.ico");
                .addPathPatterns("/admin/**");

        //addPathPatterns : ~ 로 시작하는 모든 요청에 인터셉터 적용
        //excludePathPatterns : 인터셉터를 제외할 URL 패턴을 저장
        // *	경로의 한 단계를 의미 (슬래시 / 없이 한 단어)
        //**	경로의 여러 단계 전체를 의미 (하위 폴더까지 전부 포함)
    }
}
