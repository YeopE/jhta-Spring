package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberLogoutController {

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }

}
