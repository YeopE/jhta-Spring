package com.example.demo.repository;

import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false) //롤백하지 않기
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository mr;

    @Test
    public void insert() { //JPA로 테스트 시에는 성공을 해도 자동으로 ROLLBACK을 해준다.
        Member m = new Member("hello","1234",18,"hello@hello.com");
        mr.save(m);
    }

    @Test
    public void update() {
        mr.update(new Member("hello","0000",20,"hello@hello.net"));
    }

    @Test
    public void select() {
        Member m = mr.find("hello");
        System.out.println(m);
    }

    @Test
    public void delete() {
        mr.delete("hello");
    }

    @Test
    public void count() {
        long c = mr.count1();
        System.out.println("회원수:" + c);
    }

    @Test
    public void count2() {
        long c = mr.count2();
        System.out.println("회원수:" + c);
    }

    @Test
    public void list() {
        List<Member> list = mr.select();
        list.forEach(e->{
            System.out.println(e);
        });
    }

}
