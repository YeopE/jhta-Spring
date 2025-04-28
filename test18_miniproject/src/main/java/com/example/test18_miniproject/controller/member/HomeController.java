package com.example.test18_miniproject.controller.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails,
                       Model model, HttpSession session) {
        model.addAttribute("user", userDetails);
        if(userDetails!=null) {
            session.setAttribute("id", userDetails.getUsername());
        }
        return "home";
    }

}
