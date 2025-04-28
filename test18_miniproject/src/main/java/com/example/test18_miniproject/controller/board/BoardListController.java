package com.example.test18_miniproject.controller.board;

import com.example.test18_miniproject.dto.PageResultDTO;
import com.example.test18_miniproject.service.Board1Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardListController {

    private final Board1Service board1Service;

    public BoardListController(Board1Service board1Service) {
        this.board1Service = board1Service;
    }

    @GetMapping("/boardList")
    public String boardList(@PageableDefault (size = 5, sort = "postNum", direction = Sort.Direction.DESC)Pageable pageable,
                            Model model) {

        PageResultDTO pageResultDTO = board1Service.pageList(pageable);

        model.addAttribute("list", pageResultDTO.getList());
        model.addAttribute("startPage", pageResultDTO.getStartPage());
        model.addAttribute("endPage", pageResultDTO.getEndPage());
        model.addAttribute("pageCount", pageResultDTO.getTotalPageCount());
        model.addAttribute("page", pageResultDTO.getPage());

        return "board/boardList";
    }



}
