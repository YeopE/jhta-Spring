package com.example.demo.controller;

import com.example.demo.dto.MembersDTO;
import com.example.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberListController {
    @Autowired
    private MembersService service;

    @GetMapping("/member/list")
    public String List(Model model) {
        List<MembersDTO> list = service.selectAll();
        model.addAttribute("list", list);

        //ModelAndView를 사용하여 db데이터를 얻어와 모델 객체에 담기
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("list",service.selectAll());
//        mv.setViewName("member/list");

        return "member/list";
    }
}
