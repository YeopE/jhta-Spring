package com.example.demo.repository;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository br;
    @Autowired
    private MemberRepositoryJPA mr;

    @Test
    public void save() {
        mr.save(new Member("hello","1234",10,"hello@hello.com"));
        mr.save(new Member("aaa","1111",20,"a@aaa.com"));

        Optional<Member> mem = mr.findById("hello");
        Member m = mem.get(); //optional 타입의 경우 .get()으로 받는다.
        for(int i = 1; i <= 10; i++) {
            br.save(new Board(null,m,"테스트" + i,"좋아요" + i,null));
        }
    }

    @Test
    public void findAll() {
        List<Board> blist = br.findAll();
        blist.forEach(e->{
//            System.out.println(e);
            System.out.println("글번호:" + e.getNum());
            System.out.println("작성자:" + e.getMember().getId());
            System.out.println("작성자 이메일:" + e.getMember().getEmail());
            System.out.println("제목:" + e.getTitle());
            System.out.println("내용:" + e.getContent());
            System.out.println("작성일:" + e.getRegDate());
        });
    }

    @Test
    public void list1() {
        List<Board> list = br.list1();
        for (Board board : list) {
            System.out.println(board);
        }
//        list.forEach(System.out::println); //메서드 참조 출력방식
    }

    @Test
    public void list2() {
        List<Board> list = br.list2("hello");
        list.forEach(e->{
            System.out.println(e);
        });
//        list.forEach(System.out::println); //메서드 참조 출력 방식
    }

    @Test
    public void list3() {
        List<BoardDTO> list = br.list3();
        for (BoardDTO boardDTO : list) {
            System.out.println(boardDTO);
        }
    }

    @Test
    public void delete() {
        Board b = br.findById(1L).get();
        br.deleteById(b.getNum());
//        br.deleteById(1L); //직접 값 넣어주기
    }

    @Test
    public void update() {
        Board b = br.findById(2L).get();
        b.setTitle(("update test"));
        b.setContent("update content");
//        br.save(b); //다시 저장하는 코드를 써줘도 되고 변경만해도 자동으로 db에 저장이 된다.
    }

}
