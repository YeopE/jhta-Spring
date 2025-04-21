package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @PostMapping("/main")
    public String user(
            @RequestParam("username")String username, //main.html에서 전달받은 파라미터 값
            @RequestParam("password")String password,
            Model model){ //Model을 이용하여 데이터를 다시 담을 수 있다.
        System.out.println("username:" + username);
        System.out.println("password:" + password);

        model.addAttribute("username",username);
        model.addAttribute("result","데이터가 성공적으로 등록되었어요.");

        return "showResult";
    }
}
