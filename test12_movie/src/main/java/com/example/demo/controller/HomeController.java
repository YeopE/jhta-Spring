package com.example.demo.controller;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.service.CommentsService;
import com.example.demo.service.MoiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MoiveService moiveService;
    private final CommentsService commentsService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mlist", moiveService.selectAll());
        return "home";
    }
}
