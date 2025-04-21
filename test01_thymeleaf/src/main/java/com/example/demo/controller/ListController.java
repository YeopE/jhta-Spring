package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class ListController {

    @GetMapping("/list1")
    public String List1(Model model) {
        List<String> list = new ArrayList<>();
        list.add("개나리");
        list.add("진달래");
        list.add("무궁화");
        model.addAttribute("flowers",list);

        List<User> users = new ArrayList<>();
        users.add(new User("aaaa","1111"));
        users.add(new User("bbbb","2222"));
        users.add(new User("cccc","3333"));

        model.addAttribute("users",users);

        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("aaa","111","aaa@naver.com",true));
        memberList.add(new Member("bbb","222","bbb@gmail.com",false));
        memberList.add(new Member("ccc","333","ccc@naver.com",false));
        memberList.add(new Member("ddd","444","ddd@naver.com",true));
        memberList.add(new Member("eee","555","eee@naver.com",false));

        model.addAttribute("members", memberList);

        Map<String,Object> map = new HashMap<>();
        map.put("name","홍길동");
        map.put("email","hong@naver.com");
        model.addAttribute("map",map);


        Map<String, User> map1 = new HashMap<>();
        map1.put("user1",new User("aaa","1111"));
        map1.put("user2",new User("bbb","2222"));
        model.addAttribute("userMap", map1);

        return "showList";

    }
}
