package com.example.demo;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
    @Autowired
    MemberService service;

    @Test
    public void insert() { //리턴타입은 쓸수 없고 void 만 가능하다.
        MemberDTO dto = new MemberDTO("fff","1234","fff@fff.com",20,null);
        int n = service.insert(dto);
        Assertions.assertEquals(n, 1);
    }
    @Test
    public void selectAll() {
        List<MemberDTO> list = service.selectAll();
        System.out.println(list);
    }
    @Test
    public void delete() { //Test에서는 반환값을 가질수 없으므로 void만 사용하고 파라미터값을 비워두고 아래 service.delete()에 값을 직접 넣어줘서 테스트를 한다.
        int n = service.delete("aaa");
        Assertions.assertEquals(n, 1);
    }
    @Test
    public void selectId() {
        MemberDTO dto = service.selectId("aaa");
        Assertions.assertEquals("aaa", dto.getId());
    }
    @Test
    public void update() {
        MemberDTO dto = new MemberDTO("bbb", "1212", "bbb@bbb.com",0,null);
        int n = service.update(dto);
        Assertions.assertEquals(n, 1);
    }

    @Test
    public void isMember() {
        HashMap<String,String> map = new HashMap<>();
        map.put("id","aaa");
        map.put("pwd","1234");
        MemberDTO dto = service.isMember(map);
//        Assertions.assertEquals("aaa", dto.getId());
//        Assertions.assertEquals("1234", dto.getPwd());
        log.warn("dto{}",dto);
    }
}
