package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Member1DTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class Member1ServiceTest {
    @Autowired
    private Member1Service member1Service;

    @Test
    public void memberJoin() {
        member1Service.memberJoin(new Member1DTO(null,"ddd","1234","010-1234-1234","ddd@ddd.com","경기도",null,null));
    }

    @Test
    public void findById() {
        Member1DTO dto = member1Service.findById("aaa");
        System.out.println(dto);
    }

    @Test
    public void isMember() {
        Boolean idCheck = member1Service.isMember("aaa","1234");
        if(idCheck) {
            System.out.println("일치");
        }else {
            System.out.println("불일치");
        }

    }
}
