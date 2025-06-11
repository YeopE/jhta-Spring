package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/askView")
    public void askView(){}

    @GetMapping("/imageView")
    public void imageView(){}

    @GetMapping("/imageAnalysis")
    public void imageAnalysis(){}

    @GetMapping("/textToSpeechView")
    public void textToSpeechView(){}
}
