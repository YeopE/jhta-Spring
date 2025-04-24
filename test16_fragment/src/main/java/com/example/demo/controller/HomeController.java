package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/fragmentTest")
    public void fregmentTest(){
    }

    @GetMapping("/member")
    public void member() {
    }

    @GetMapping("/item")
    public void item(){
    }
}
