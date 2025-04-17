package com.example.demo;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class MemberServiceTest {
    @Autowired
    private MemberService service;

    @Test
    public void insert() {
        MemberDTO dto = MemberDTO.builder()
                .id("qwer")
                .age(20)
                .pwd("1234")
                .email("qwer@qwer.com")
                .build();
        MemberDTO m = service.insert(dto);
        System.out.println(m);
//        service.insert(dto);
    }

//    @Test
//    public void list() {
//        service.list().forEach(System.out::println);
//    }

    @Test
    public void update() {
        MemberDTO dto = service.select("hello");
        System.out.println("변경전 dto ==>" + dto);
        MemberDTO updateDto = service.update(new MemberDTO("hello","1111","hello@hello.com",22,null));
        System.out.println("변경후 dto ==>" + updateDto);
    }

    @Test
    public void delete() {
        service.delete("hello");
    }

}
