package com.example.demo.config;

import com.example.demo.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //빈을 사용하기 위해 configuration 등록
public class WebConfig {
    @Bean //빈 등록
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LoginFilter());
        bean.setOrder(1);
        bean.addUrlPatterns("/*"); //경로
        return bean;
    }
}
