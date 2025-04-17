package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardUpdateControlle {
    private final BoardService service;

    @GetMapping("/update")
    public String updateForm(@RequestParam("num")Long num,
                             Model model) {

        BoardDTO dto = service.select(num);

        model.addAttribute("dto", dto);

        return "board/update";
    }

    @PostMapping("/update")
    public String update(BoardDTO dto) {
        BoardDTO updateDTO = service.update(dto);

        return "redirect:/board/list";
    }
}
