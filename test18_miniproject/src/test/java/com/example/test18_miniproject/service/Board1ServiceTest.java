package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Board1DTO;
import com.example.test18_miniproject.entity.Member1;
import com.example.test18_miniproject.repository.Member1Repository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class Board1ServiceTest {
    @Autowired
    private Board1Service board1Service;
    @Autowired
    private Member1Repository member1Repository;

    @Test
    public void insert() {
        Member1 member1 = member1Repository.findById("ccc");
        board1Service.insert(new Board1DTO(null,member1,"제목1","내용1","img1.jpg","img2.jpg","img3.jpg",null,null));
    }
}
