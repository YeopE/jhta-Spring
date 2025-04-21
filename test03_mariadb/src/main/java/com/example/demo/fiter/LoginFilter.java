package com.example.demo.fiter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    String[] whiteList={"/","/member/login","/member/logout","/member/insert","/css"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        System.out.println("요청 uri ==>" + uri);

        if(isLoginCheck(uri)) {
            if(session == null || session.getAttribute("id") == null) {
                response.sendRedirect(request.getContextPath() + "/member/login");
                return;
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
    private boolean isLoginCheck(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whiteList, requestURI);
    }

}
