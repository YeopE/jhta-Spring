package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void insert() {
        MemberDTO dto = new MemberDTO("sss","1234","sss@sss.com",20,null);
        int n = memberService.insert(dto);
//        Assertions.assertEquals(n, 1);
//        log.debug("n:" + n); //System.out.println("n:" + n) 과 같이 이렇게 써도 되지만 아래와 같이 써주는게 정석.
        log.warn("n:{}", n); //변수가 들어갈 자리에 {} 을 넣고 변수를 , 뒤에 넣어준다.
    }

    @Test
    public void selectId() {
        MemberDTO dto = memberService.selectId("aaa");
        Assertions.assertEquals("aaa", dto.getId());
    }

    @Test
    public void isMember() {
        HashMap<String,String> map = new HashMap<>();
        map.put("id", "aaa");
        map.put("pwd", "1234");
        MemberDTO dto = memberService.isMember(map);
        log.warn("dto:{}", dto);
    }


}
