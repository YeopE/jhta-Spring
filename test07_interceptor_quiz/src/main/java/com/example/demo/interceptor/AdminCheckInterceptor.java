package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//
//        try {
//            if(session!=null && !(session.getAttribute("role").equals("ADMIN")) ) {
//                response.sendRedirect(request.getContextPath() + "/");
//            }
//        }catch (NullPointerException ne) {
//            System.out.println(ne);
//        }
//
//        return true;
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("id")!=null) {
            String role=(String)session.getAttribute("role");
            if(!role.equals("ADMIN")) {
                response.sendRedirect(request.getContextPath() + "/forbidden");
                return false;
            }else {
                return true;
            }
        }else {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return false;
        }
    }
}
