package com.example.demo.controller;

import com.example.demo.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberJoin {

    @GetMapping("/member/join")
    public String joinFrom() {
        return "member/join";
    }

//    @PostMapping("/member/join")
//    public String join(Member mem, Model model) { //dto를 통해 파라미터값을 담을 수 있는데 이름이 동일해야한다.
//        System.out.println(mem);
//        System.out.println("db저장..........");
//        model.addAttribute("mem",mem);
//        return "member/result";
//    }
    @PostMapping("/member/join")
    public String join(@ModelAttribute Member mem) { //ModelAttribute의 기본으로 담길 때에는 Member클래스의 이름을 맨 앞에 소문자로 바뀌어 member 로 Model 객체가 저장이 된다.)
        System.out.println("db저장.........");

        return "member/result";
    }
}
