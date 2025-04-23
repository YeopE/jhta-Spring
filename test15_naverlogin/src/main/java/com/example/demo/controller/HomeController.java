package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    //@AuthenticationPrincipal : 시큐리티가 사용하는 컨텍스트영역에서 UserDetails객체 얻어오기
    public String home(@AuthenticationPrincipal UserDetails userDetails,
                       Model model){
        model.addAttribute("user",userDetails);
        return "home";
    }
}
