package com.example.demo.controller;

import com.example.demo.dto.MembersDTO;
import com.example.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberUpdateController {
    @Autowired
    private MembersService service;

    @GetMapping("/member/update")
    public String updateForm(@RequestParam("num") int num, Model model) {
        MembersDTO dto = service.getinfo(num);
        model.addAttribute("dto", dto);

        return "member/update";
    }

    @PostMapping("/member/update")
    public  String update(@ModelAttribute MembersDTO dto) { //view page에서 파라미터로 받은 애들을 그대로 담고 싶다면 ModelAttribute를 사용한다.
        service.update(dto);

//        return "redirect:/member/list";
        return "/member/result";
    }
}
