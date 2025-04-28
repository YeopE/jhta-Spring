package com.example.test18_miniproject.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberLoginController {
    @GetMapping("/login")
    public String loginForm() {
        return "member/memberLogin";
    }

}
