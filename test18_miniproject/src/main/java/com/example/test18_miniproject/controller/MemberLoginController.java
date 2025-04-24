package com.example.test18_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberLoginController {
    @GetMapping("/member/login")
    public String loginForm() {
        return "member/memberLogin";
    }

}
