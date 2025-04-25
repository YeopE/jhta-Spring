package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Member1DTO;
import com.example.test18_miniproject.dto.PageResultDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
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

    @Test
    public void update() {
        Member1DTO dto = member1Service.findById("aaa");
        System.out.println("변경전 dto ==>" + dto);
        Member1DTO updateDTO = member1Service.memberUpdate(new Member1DTO(0L,"aaa","1111","010-1111-1111","a@a.com","충청도",null, null));
        System.out.println("변경후 dto ==>" + dto);
    }

    @Test
    public void List() {
        PageRequest pageable = PageRequest.of(0, 5);
        PageResultDTO dto = member1Service.pageList(pageable);
        System.out.println(dto);
    }

    @Test
    public void delete() {
        member1Service.memberDelete(2L);
    }
}
