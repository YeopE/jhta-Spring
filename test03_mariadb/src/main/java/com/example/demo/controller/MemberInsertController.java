package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberInsertController {
    @Autowired
    private MemberService service;

    @GetMapping("/member/insert")
    public String insertForm(@ModelAttribute MemberDTO memberDTO) {
        return "member/insert";
    }

    @PostMapping("/member/insert")
    public String insert(@ModelAttribute MemberDTO memberDTO,
                         Model model,
                         BindingResult bindingResult) {
        if(!StringUtils.hasText(memberDTO.getId())) {
            bindingResult.addError(new FieldError("memberDTO","id","아이디를 입력하세요."));
        }
        if(!StringUtils.hasText(memberDTO.getPwd())) {
            bindingResult.addError(new FieldError("memberDTO","pwd","비밀번호를 입력하세요."));
        }
        String email = memberDTO.getEmail();
        if(!email.contains("@")) {
            bindingResult.addError(new FieldError("memberDTO","email","올바른 이메일 형식이 아닙니다."));
        }
        int age = memberDTO.getAge();
        if(age <= 0 || age > 150) {
            bindingResult.addError(new FieldError("memberDTO","age","0살 ~ 150살 사이로 입력하세요."));
        }
        if(bindingResult.hasErrors()){//에러가 존재하면 가입페이지로 이동하기
            return "member/insert";
        }

        service.insert(memberDTO);
        MemberDTO saveDTO = service.selectId(memberDTO.getId());
        model.addAttribute("dto", saveDTO);
        return "member/result";
    }
}
