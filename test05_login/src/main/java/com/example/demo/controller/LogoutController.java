package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/member/logout")
    public String logout(HttpServletRequest request) {

        request.getSession().removeAttribute("dto"); //session에 담긴 "dto"를 제거
//        request.getSession().invalidate(); //session을 무효화

        return "redirect:/";
    }
}
