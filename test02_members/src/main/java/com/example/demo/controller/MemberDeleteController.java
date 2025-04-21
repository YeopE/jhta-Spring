package com.example.demo.controller;

import com.example.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberDeleteController {

    @Autowired
    private MembersService service;

//    @GetMapping("/member/delete/{num}")
//    public String delete(@PathVariable("num") int num) {
//        System.out.println("삭제된 번호:" + num);
//        service.delete(num);
//        return "member/result";
//    }

    @GetMapping("/member/delete")
    public String delete(@RequestParam("num") int num) { //파라미터값의 이름과 받는 이름이 동일하면 num 그대로 들어간다. //예전 버전에서는 @RequestParam("num") 이 생략이 되도 됐었는데 되도록 넣는게 좋다.
        service.delete(num);
        //return "member/list"; //그냥 이동하게되면 데이터가 없는 viewpage로 이동한다.
        // redirect: 를 넣어서 리다이렉트방식으로 컨트롤러 호출
        return "redirect:/member/list";
    }

}
