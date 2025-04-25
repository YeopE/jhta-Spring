package com.example.test18_miniproject.controller;

import com.example.test18_miniproject.dto.Member1DTO;
import com.example.test18_miniproject.service.Member1Service;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberUpdateController {
    private final Member1Service member1Service;

    @GetMapping("/member/update")
    public String updateFomr(HttpSession session,
                             Model model) {
        String id =(String)session.getAttribute("id");
        Member1DTO dto = member1Service.findById(id);
        model.addAttribute("dto", dto);

        return "member/memberUpdate" ;
    }

    @PostMapping("/member/update")
    public String update(Member1DTO dto,
                         Model model) {
        Member1DTO updateDTO = member1Service.memberUpdate(dto);

        return "member/updateResult";
    }
}
