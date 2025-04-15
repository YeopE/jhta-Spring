package com.example.demo.seviceTest;

import com.example.demo.dto.MembersDTO;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
@Slf4j
public class MembersServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void isMember() {
        HashMap<String,String> map = new HashMap<>();
        map.put("id","aaa");
        map.put("pwd","1234");
        MembersDTO dto = memberService.isMember(map);
        log.warn("dto{}",dto);
    }
}
