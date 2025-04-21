package com.example.demo.controller;

import com.example.demo.dto.MovieDTO;
import com.example.demo.service.MoiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MoiveService moiveService;

    @GetMapping("/movie/detail")
    public String detail(@RequestParam("mnum")long mnum,
                         Model model) {
        MovieDTO dto = moiveService.selectMnum(mnum);
        model.addAttribute("movie",dto);
        return "movie/detail";
    }
}
