package com.example.demo.repository;

import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryJPATest {
    @Autowired
    private MemberRepositoryJPA mr;

    @Test
    public void insert() {
        Member m = mr.save(new Member("test","1111",10,"test@test.com"));
        System.out.println("m==>" + m);
    }

    @Test
    public void delete() {
        mr.deleteById("test");
    }

    @Test
    public void select() {
        Optional<Member> optionalMember = mr.findById("hello");
        if(!optionalMember.isEmpty()) {
            Member m = optionalMember.get();
            System.out.println(m);
        }else {
            System.out.println("데이터가 존재하지 않아요.");
        }
    }

    @Test
    public void update() {
        Member m = mr.findById("hello").get(); //Optinal로 감싸져 있는 객체는 get()으로 꺼내온다.
        m.setEmail("hello@email.com");
        m.setAge(30);
        m.setPassword("0000");
        System.out.println("수정완료");
    }
    
    @Test
    public void selectList() {
        List<Member> list = mr.findAll(); //전체데이터 조회
        for(Member member : list) {
            System.out.println(member);
        }
    }

    @Test
    public void selectOnd() {
        Member member = mr.select("hello");
        System.out.println(member);
    }

    @Test
    public void findMember() {
        Member member = mr.findMember("hello","0000");
        System.out.println(member);
    }

    @Test
    public void findAge() {
        List<Member> list = mr.findAgeMember(20);
        list.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void findIds() {
        List<String> ids = new ArrayList<>();
        ids.add("hello");
        ids.add("test");
        List<Member> list = mr.findMembers(ids);
        list.forEach(System.out::println);
    }
}
