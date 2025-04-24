package com.example.test18_miniproject.controller;

import com.example.test18_miniproject.dto.Member1DTO;
import com.example.test18_miniproject.service.Member1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberJoinController {
    private final Member1Service member1Service;

    @GetMapping("/member/join")
    public String memberJoinForm() {
        return "member/memberjoin";
    }

    @PostMapping("/member/join")
    public String memberJoin(Member1DTO member1DTO,
                             Model model) {
        try {
            Member1DTO saveDTO = member1Service.memberJoin(member1DTO);
            model.addAttribute("dto", saveDTO);
        }catch (Exception e){
            model.addAttribute("fail","가입에 실패하였습니다.");
            return "member/joinResult";
        }

        return "member/joinResult";
    }
}
