package com.example.test18_miniproject.controller.member;

import com.example.test18_miniproject.service.Member1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MemberDeleteController {
    private final Member1Service member1Service;

    @GetMapping("/admin/delete/{idNum}")
    public String delete(@PathVariable Long idNum) {
        member1Service.memberDelete(idNum);

        return "redirect:/admin/memberList";
    }
}
