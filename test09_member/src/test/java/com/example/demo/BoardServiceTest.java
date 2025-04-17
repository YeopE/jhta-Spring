package com.example.demo;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.PageResultDTO;
import com.example.demo.service.BoardService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class BoardServiceTest {
    @Autowired
    private BoardService service;

    @Test
    public void insert() {
        BoardDTO dto = BoardDTO.builder()
                .title("제목1")
                .id("hello")
                .content("컨텐츠1")
                .build();
        BoardDTO b = service.insert(dto);
//        BoardDTO dto = service.insert(new BoardDTO(null,"hello","제목1","내용1",null));
        System.out.println(b);
    }

    @Test
    public void list() {
        PageRequest pageable = PageRequest.of(0,5);
        PageResultDTO dto = service.list(pageable);
        System.out.println(dto);
    }

    @Test
    public void delete() {
        service.delete(29L);
    }

    @Test
    public void update() {
        BoardDTO dto = service.select(1L);
        System.out.println("변경전 dto ==>" + dto);
        BoardDTO updateDTO = service.update(new BoardDTO(1L,"hello","제목변경","컨텐츠변경",null));
        System.out.println("변경후 dto ==>" + updateDTO);
    }
}
