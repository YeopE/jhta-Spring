package com.example.test18_miniproject.controller.board;

import com.example.test18_miniproject.service.Board1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BoardDeleteController {
    private final Board1Service board1Service;

    @GetMapping("/board/delete")
    public String delete(@RequestParam("postNum")Long postNum) {
        board1Service.delete(postNum);

        return "redirect:/boardList";
    }
}
