package com.example.demo;

import com.example.demo.dto.MembersDTO;
import com.example.demo.service.MembersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MembersServiceTest {
    @Autowired
    MembersService service;

    @Test
    public void insert() {
        MembersDTO dto = new MembersDTO(2,"홍길동","010-1111-1111","서울",null);
        int n = service.insert(dto);
        System.out.println("n:" + n);
    }
    @Test
    public void delete() {
        int n = service.delete(1);
        Assertions.assertEquals(n, 1); //assertEquals 기댓값과 실제 값이 일치하는지 확인하는 메서드
    }
    @Test
    public void update() {
        MembersDTO dto = new MembersDTO(1, "이길동", "010-1234-1234", "인천", null);
        int n = service.update(dto);
        System.out.println("n:" + n);
    }
    @Test
    public void getinfo() {
        MembersDTO dto = service.getinfo(1);
        System.out.println(dto);
    }
    @Test
    public void selectAll() {
        List<MembersDTO> list = service.selectAll();
        System.out.println(list);
    }
}
