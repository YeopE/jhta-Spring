package com.example.demo.controller;

import com.example.demo.dto.MembersDTO;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/member")
public class LoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id")String id,
                        @RequestParam("pwd")String pwd,
                        HttpSession session
                        ) {

        HashMap<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("pwd",pwd);

        MembersDTO dto = memberService.isMember(map);

        if(dto == null) {
            return "member/login";
        }

        session.setAttribute("id",id);
        session.setAttribute("role",dto.getRole());
        System.out.println(id);
        System.out.println(session.getAttribute("role"));

        return "redirect:/";
    }

}
