package com.example.demo.service;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class CommentsRepositoryTest {
    @Autowired private MovieRepository movieRepository;
    @Autowired private CommentsRepository commentsRepository;

    @Test
    public void list() {
        //영화번호 1번에 대한 댓글 5개를 출력해 보세요(최신 댓글 순으로 1페이지)
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by("cnum").descending());
        Page<Comments> page = commentsRepository.findByMnum(1L, pageRequest);
//        page.forEach(System.out::println);
        List<Comments> clist = page.getContent();
        clist.forEach(c->{
            System.out.println("영화번호==>" + c.getMovie().getMnum());
            System.out.println("댓글번호:" + c.getCnum());
            System.out.println("작성자:" + c.getId());
            System.out.println("내용:" + c.getComments());
            System.out.println();
        });
    }

    //전체 영화에 대한 댓글 출력 해보세요(댓글 5개)
    @Test
    void commList() {
        List<Movie> list = movieRepository.findAll();
        PageRequest pageRequest = PageRequest.of(0,5,Sort.by("cnum").descending());
        list.forEach(m->{
            System.out.println(m.getMnum() + "," + m.getTitle() + "," + m.getContent() + "," + m.getDirector());
            System.out.println("<< 댓글 >>");
            Page<Comments> clist = commentsRepository.findByMnum(m.getMnum(),pageRequest);
            clist.forEach(c->{
                System.out.println(c.getCnum() + "," + c.getId() + "," + c.getComments());
            });
            System.out.println("--------------------------");
        });
    }
}

