package com.example.demo;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
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
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository mr;

    @Test
    public void list1() {
        List<Member> list1 = mr.list1(0,3);
        list1.forEach(m->
            System.out.println(m)
        );
    }

    @Test
    public void list2() {
        List<Member> list1 = mr.list1(0,5);
        list1.forEach(m->
                System.out.println(m)
        );
    }

    @Test
    public void list3() {
        //public Page<Member> selectAll(Pageable pageable);
        //PageRequest pageable = PageRequest.of(1,3); //2페이지부터 3개 꺼냄 (pageNumber = 0부터 시작, 0부터 시작 0이 1페이지)
        //PageRequest pageable = PageRequest.of(0,3);
        PageRequest pageable = PageRequest.of(0,3,Sort.by("age").descending()); //정렬 : Sort.by("컬럼명"), 기본 오름차순, descending() : 내림차순
        Page<Member> page = mr.findAll(pageable);
        System.out.println("전체페이지수:" + page.getTotalPages());
        List<Member> list = page.getContent();
        list.forEach(m-> System.out.println(m));

    }

    @Test
    public void increaAge() {
        int n = mr.update("hello");
        System.out.println("n==>" + n);
    }

    @Test
    public void pageList() {
        PageRequest pageable = PageRequest.of(0,5);
        Page<Member> page = mr.findAll(pageable);
        System.out.println("페이지갯수:" + page.getTotalPages());
        System.out.println("페이지번호:" + page.getNumber());
        page.getContent().forEach(System.out::println);
    }
}
