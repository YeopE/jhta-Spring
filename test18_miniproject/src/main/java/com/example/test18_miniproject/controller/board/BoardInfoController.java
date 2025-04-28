package com.example.test18_miniproject.controller.board;

import com.example.test18_miniproject.service.Board1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BoardInfoController {
    private final Board1Service board1Service;

    @GetMapping("/board/info")
    public String boardInfo(@RequestParam("postNum")Long postNum,
                            Model model) {
        model.addAttribute("dto", board1Service.select(postNum));

        return "board/boardInfo";
    }
}
