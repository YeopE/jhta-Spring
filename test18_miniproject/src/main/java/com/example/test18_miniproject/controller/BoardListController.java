package com.example.test18_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardListController {

    @GetMapping("/boardList")
    public String boardList() {

        return "board/boardList";
    }


}
