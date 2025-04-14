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
public class MemberJoinController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/join")
    public String joinForm(@ModelAttribute MemberDTO memberDTO) {

        return "member/insert";
    }

    @PostMapping("/member/join")
    public String join(@ModelAttribute MemberDTO memberDTO,
                       BindingResult bindingResult,
                       Model model) {
        if(!StringUtils.hasText(memberDTO.getId())) { //id 텍스트가 비어있으면
            //bindingResult에 에러담기 new FieldError("객체명", "필드명", "에러메시지")
            bindingResult.addError(new FieldError("memberDTO","id","아이디를 입력하세요."));
        }
        if(!StringUtils.hasText(memberDTO.getPwd())){
            bindingResult.addError(new FieldError("memberDTO","pwd","비밀번호를 입력하세요."));
        }
        // 이메일에 @가 포함되어 있는지 검사
        String email = memberDTO.getEmail();
        if(!email.contains("@")) {
            bindingResult.addError(new FieldError("memberDTO","email","올바른 이메일 형식이 아닙니다."));
        }
        //나이가 0살에서 150사이인지 검사
        int age = memberDTO.getAge();
        if(age < 0 || age > 150) {
            bindingResult.addError(new FieldError("memberDTO","age","0살 ~ 150살 사이로 입력하세요."));
        }
        if(bindingResult.hasErrors()){//에러가 존재하면 가입페이지로 이동하기
            return "member/insert";
        }

        try {
            memberService.insert(memberDTO);
            MemberDTO selectId = memberService.selectId(memberDTO.getId());
            model.addAttribute("dto",selectId);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "member/result";
    }
}
