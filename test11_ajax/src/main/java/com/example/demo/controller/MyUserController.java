package com.example.demo.controller;

import com.example.demo.dto.MyUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController// @Controller + @ResponseBody 어노테이션을 쓴것과 동일하게 응답 (ajax로 요청할때)
public class MyUserController {
//    @GetMapping("/users/{id}") // http://localhost:8080/user/hello
//    @ResponseBody
//    public MyUser info(@PathVariable("id")String id){
//        if(id.equals("hello")){
//            return new MyUser("hello","1234","hello@hello.com");
//        }else {
//           return new MyUser("none","none","none");
//        }
//    }
    @GetMapping("/users/{id}")
    public ResponseEntity<MyUser> info1(@PathVariable("id")String id){
        MyUser m = null;
        if(id.equals("hello")){
            m = new MyUser("hello","1234","hello@hello.com");
        }else {
            m = new MyUser("none","none","none");
        }

        ResponseEntity<MyUser> responseEntity = new ResponseEntity<>(m, HttpStatus.OK); //(m = 결과값, HttpStatus.OK = 응답코드)
        return responseEntity;
    }

    @GetMapping("users")
    public ResponseEntity<List<MyUser>> getList() {
        MyUser m1 = new MyUser("hello1", "1234", "hello1@hello.com");
        MyUser m2 = new MyUser("hello2", "1212", "hello2@hello.com");
        MyUser m3 = new MyUser("hello3", "1313", "hello3@hello.com");
        List<MyUser> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        ResponseEntity<List<MyUser>> resp = new ResponseEntity<List<MyUser>>(list, HttpStatus.OK);
        return resp;
    }

}
