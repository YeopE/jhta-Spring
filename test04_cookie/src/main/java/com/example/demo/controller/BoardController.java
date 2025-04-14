package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String board(HttpServletRequest request,
                        Model model) {
        // 로그인한 사용자인지 검사 - 쿠키에 아이디가 있는지 검사
        Cookie[] cookies = request.getCookies();
        boolean login = false;
        if(cookies!=null) {
            for(Cookie cookie : cookies) {
                String name = cookie.getName();
                if(name.equals("id")){
                    login = true;
                }
            }
        }

        // 로그인안한 사용자이면 로그인페이지로 이동
        if(!login) {
            return "redirect:/login";
        }

        // 로그인한 사용자면 member/board.html 페이지로 이동
        List<String> list = new ArrayList<>();
        list.add("게시글1");
        list.add("게시글2");
        list.add("게시글3");

        model.addAttribute("boards", list);

        return "member/board";
    }
}
