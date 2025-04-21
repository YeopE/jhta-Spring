package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/") //경로를 주지 않으면 상위 경로로 지정 //GetMapping ==> get방식
    public String home(Model model) {
        //뷰페이지에 전달할 객체 담기
        model.addAttribute("msg","헬로헬로");
        //뷰이름 리턴 : templates폴더의 home.html로 이동
        return "home";
    }

    @GetMapping("/link1")
    public String link1(@RequestParam("id")String id,
                        @RequestParam("pwd")String pwd){
        System.out.println(id + "," + pwd);
        return "home";
    }

    // /link2/aa/1234
    @GetMapping("/link2/{id}/{pwd}")
    public String link2(@PathVariable("id") String id, //id는 /list2/{id}/{pwd} 의 id와 name이 동일해야 한다.
                        @PathVariable("pwd") String pwd) { //pwd는 /list2/{id}/{pwd} 의 pwd와 name이 동일해야 한다.
        System.out.println("id ===>" + id);
        System.out.println("pwd ===>" + pwd);
        return "home";
    }

    @GetMapping("/mydate")
    public String dateFormat(Model model) {
        model.addAttribute("date1", new Date()); //Date = java.util
        model.addAttribute("date2", LocalDateTime.now());

        return "mydate";
    }
}
