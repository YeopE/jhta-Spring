package com.example.demo.service;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.dto.MovieDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class MovieServiceTest {
    @Autowired
    private MoiveService movieService;
    @Autowired
    private CommentsService commentsService;

    @Test
    void save() {
        movieService.save(new MovieDTO(null,"스프링부트","재미난이야기","이감독"));
        movieService.save(new MovieDTO(null,"무서운영화","무서운이야기","최감독"));
    }

    @Test
    void commetsSave() {
        commentsService.save(new CommentsDTO(null,1L,"멍멍이","흥미진진해요"));
        for(int i = 1; i <= 12; i++) {
            commentsService.save(new CommentsDTO(null,2L,"야옹이"+i,"무서워....." + i));
        }
    }
}
