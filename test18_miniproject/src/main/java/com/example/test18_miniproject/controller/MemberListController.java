package com.example.test18_miniproject.controller;

import com.example.test18_miniproject.dto.PageResultDTO;
import com.example.test18_miniproject.service.Member1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberListController {
    private final Member1Service member1Service;

    @GetMapping("/admin/memberList")
    public String memberList(@PageableDefault (size = 5, sort = "regdate", direction = Sort.Direction.DESC)Pageable pageable,
                             Model model) {

        PageResultDTO pageResultDTO = member1Service.pageList(pageable);

        model.addAttribute("list", pageResultDTO.getList());
        model.addAttribute("startPage", pageResultDTO.getStartPage());
        model.addAttribute("endPage", pageResultDTO.getEndPage());
        model.addAttribute("pageCount", pageResultDTO.getTotalPageCount());
        model.addAttribute("page", pageResultDTO.getPage());

        return "member/memberList";
    }
}
