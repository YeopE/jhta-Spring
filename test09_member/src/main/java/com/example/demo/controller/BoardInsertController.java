package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardInsertController {

    @Autowired
    private BoardService service;

    @GetMapping("/insert")
    public String insertForm() {
        return "board/insert";
    }

    @PostMapping("/insert")
    public String insert(BoardDTO dto,
                         Model model) {
        try {
            service.insert(dto);
            model.addAttribute("result", "success");
        }catch (Exception e) {
            service.insert(dto);
            model.addAttribute("result","fail");
        }
        return "member/result";
    }

}
