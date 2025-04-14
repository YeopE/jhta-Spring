package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hone() {
        return "home";
    }

    @GetMapping("/product")
    public String product() {
        return "member/product";
    }
}
