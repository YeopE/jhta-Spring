package com.example.demo.repository;

import com.example.demo.dto.MyUserDTO;
import com.example.demo.entity.MyUser;
import com.example.demo.service.My_userService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class My_userServiceTest {
    @Autowired
    private My_userService service;

    @Test
    public void insert() {
        MyUserDTO dto = MyUserDTO.builder()
                                 .num(3)
                                 .name("삼길동")
                                 .phone("010-3333-3333")
                                 .addr("부산")
                                 .build();
        MyUserDTO mu = service.insert(dto);
        System.out.println(mu);
    }

    @Test
    public void list() {
        List<MyUserDTO> list = service.list();
        list.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void update() {
        MyUserDTO dto = service.select(3);
        System.out.println("변경전 ==>" + dto);
        MyUserDTO updateDTO = service.update(new MyUserDTO(3,"삼길동","010-1234-1234","경기도",null,null));
        System.out.println("변경후 ==>" + updateDTO);
    }

    @Test void delete() {
        service.delete(3);
    }
}
