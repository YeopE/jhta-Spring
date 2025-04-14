package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(@RequestParam("id")String id,
                        @RequestParam("pwd")String pwd,
                        HttpSession session,
                        HttpServletRequest request) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("id",id);
        hashMap.put("pwd",pwd);
        MemberDTO dto = memberService.isMember(hashMap);

        if(dto == null) {
            return "member/login";
        }

        session.setAttribute("dto", dto);
        //session.setAttribute("id",id); //session에 객체를 담을 수도 있고 값을 따로 담을 수 있는데 객체를 담을 경우 메모리를 많이차지하기 때문에 필요한 것만 담아주는게 좋다.
        //request.getSession().setAttribute("id",id); //request를 통해서도 session을 얻어올 수 있다.
        return "redirect:/";
    }
}
