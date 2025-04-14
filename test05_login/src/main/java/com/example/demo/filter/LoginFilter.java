package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {
    //필터가 동작되지 않을 uri(경로) 설정 //uri 값 : 풀경로 url에서 contextPath() 다음으로 들어가는 부분
    String[] whiteList={"/","/member/login","/member/join","/member/logout","/css"};
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //로그인체크

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();//요청 uri값 얻어오기
        System.out.println("요청 uri ==>" + uri); //uri => member/login
        if(isLoginCheck(uri)) { //로그인한 사용자만 볼 수 있는 페이지 -> 로그인했는지 검사함
            if (session == null || session.getAttribute("dto") == null) {
                //로그인페이지로 이동
                response.sendRedirect(request.getContextPath() + "/member/login");
                return;
            }
        }
        //요청페이지로 이동
        filterChain.doFilter(servletRequest,servletResponse);
    }
    private boolean isLoginCheck(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whiteList, requestURI);
    }
}
