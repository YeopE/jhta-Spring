package com.example.demo;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository br;

    @Test
    public void pageList() {
        PageRequest pageable = PageRequest.of(0,5);
        Page<Board> page = br.findAll(pageable);
        System.out.println("페이지갯수:" + page.getTotalPages());
        System.out.println("페이지번호:" + page.getNumber());
        page.getContent().forEach(System.out::println);
    }
}
