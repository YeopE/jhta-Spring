package com.example.demo.controller;

import com.example.demo.dto.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/member")
    public String member() {
        return "member/main";
    }


//    @GetMapping("/")
//    @ResponseBody //return 된 값으로 응답
//    public String hone() {
//
//        return "안녕하세요";
//    }

    @GetMapping("/user")
    @ResponseBody
    public MyUser user() {
        MyUser mu = new MyUser("hello","1234","hello@hello.com");
        return mu;
    }

}
