package com.example.demo.controller;

import com.example.demo.dto.PageResultDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BoardListController {
    private final BoardService service;

    @GetMapping("/board/list")
    public String list(@PageableDefault (size = 3,sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {
        PageResultDTO pageResultDTO = service.list(pageable);

        model.addAttribute("list", pageResultDTO.getList());
        model.addAttribute("startPage", pageResultDTO.getStartPage());
        model.addAttribute("endPage", pageResultDTO.getEndPage());
        model.addAttribute("pageCount", pageResultDTO.getTotalPageCount());
        model.addAttribute("page",pageResultDTO.getPage()); //현재 페이지번호

        return "board/list";
    }

    @GetMapping("/board/list1")
    public String list1(@RequestParam(value="page", defaultValue="0")int page,
                       Model model){
        PageRequest pageable = PageRequest.of(page,3, Sort.by("num").descending());
        PageResultDTO pageResultDTO = service.list(pageable);

        model.addAttribute("list", pageResultDTO.getList());
        model.addAttribute("startPage", pageResultDTO.getStartPage());
        model.addAttribute("endPage", pageResultDTO.getEndPage());
        model.addAttribute("pageCount", pageResultDTO.getTotalPageCount());
        model.addAttribute("page",pageResultDTO.getPage()); //현재 페이지번호

        return "board/list";
    }
}
