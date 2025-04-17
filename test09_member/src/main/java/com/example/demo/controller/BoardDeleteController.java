package com.example.demo.controller;

import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardDeleteController {
    private final BoardService service;

    @GetMapping("/board/delete")
    public String delete(@RequestParam("num")Long num,
                         RedirectAttributes redirectAttributes) { //RedirectAttributes 모델 객체처럼 값을 담아줌
        service.delete(num);
        redirectAttributes.addFlashAttribute("msg","삭제완료!");

        return "redirect:/board/list";
    }
}
