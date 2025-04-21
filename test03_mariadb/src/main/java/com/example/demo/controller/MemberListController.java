package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class MemberListController {
    @Autowired
    private MemberService service;

    @GetMapping("/member/list")
//    public String memberList(Model model) {
//        List<MemberDTO> list = service.selectAll();
//
//        model.addAttribute("list", list);
//
//        return ("member/list");
//    }
    public String list(@RequestParam(name="page",defaultValue = "1")int page,Model model) {
        int start=(page-1)*3;
        int startPage=(page-1)/3*3+1;
        int endPage=startPage+2;
        int pageCount=(int)Math.ceil(service.count()/3.0);
        if(endPage>pageCount) {
            endPage=pageCount;
        }
        HashMap<String,Object> map=new HashMap<>();
        map.put("startRow", start);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("list", service.list(map));
        model.addAttribute("page",page);

        return "member/list";
    }
}
