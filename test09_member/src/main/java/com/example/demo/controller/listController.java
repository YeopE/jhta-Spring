package com.example.demo.controller;

import com.example.demo.dto.PageResultDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class listController {
    @Autowired
    private MemberService service;

    @GetMapping("/list")
//    public String list(Model model) {
//        model.addAttribute("list", service.list());
//        return "member/list";
    public String pagingList(@PageableDefault (size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
                             Model model) {
        PageResultDTO pageResultDTO = service.pageList(pageable);

        model.addAttribute("list", pageResultDTO.getList());
        model.addAttribute("startPage", pageResultDTO.getStartPage());
        model.addAttribute("endPage", pageResultDTO.getEndPage());
        model.addAttribute("pageCount", pageResultDTO.getTotalPageCount());
        model.addAttribute("page", pageResultDTO.getPage());

        return "member/list";
    }

}
