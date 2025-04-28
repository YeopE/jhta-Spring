package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Board1DTO;
import com.example.test18_miniproject.dto.PageResultDTO;
import com.example.test18_miniproject.entity.Board1;
import com.example.test18_miniproject.entity.Member1;
import com.example.test18_miniproject.repository.Board1Repository;
import com.example.test18_miniproject.repository.Member1Repository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class Board1ServiceTest {
    @Autowired
    private Board1Service board1Service;
    @Autowired
    private Member1Repository member1Repository;
    @Autowired
    private Board1Repository board1Repository;

    @Test
    public void insert() {
        Member1 member1 = member1Repository.findById("ccc");
        board1Service.insert(new Board1DTO(null,member1,"제목1","내용1","img1.jpg","img2.jpg","img3.jpg",null,null));
    }

    @Test
    public void List() {
        PageRequest pageable = PageRequest.of(0, 5);
        PageResultDTO dto = board1Service.pageList(pageable);
        System.out.println(dto);
    }

    @Test
    public void select() {
        Long postNum = 1L;
        Board1DTO dto = board1Service.select(postNum);
        System.out.println(dto);
    }

    @Test
    public void delete() {
        Long postNum = 7L;
        board1Service.delete(postNum);
    }

    @Test
    public void update() {
        Long postNum = 5L;

        Board1DTO board1DTO = board1Service.select(postNum);

        Board1DTO updateDTO = new Board1DTO(board1DTO.toEntity());
        updateDTO.setTitle("제목 수정");
        updateDTO.setContent("내용 수정");

        Board1DTO resultDTO = board1Service.update(updateDTO);

        System.out.println(resultDTO);
    }

}
