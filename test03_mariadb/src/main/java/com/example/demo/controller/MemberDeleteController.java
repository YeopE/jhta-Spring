package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberDeleteController {
    @Autowired
    private MemberService service;

    @GetMapping("/member/delete")
    public String delete(String id) {
        service.delete(id);

        return "redirect:/member/list";
    }
}
