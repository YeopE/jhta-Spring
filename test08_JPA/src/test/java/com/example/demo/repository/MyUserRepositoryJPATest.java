package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MyUserRepositoryJPATest {
    @Autowired
    private MyUserRepositoryJPA mr;

    @Test
    public void insert() {
        MyUser mu = mr.save(new MyUser(1,"홍길동","010-1111-1111","서울"));
        System.out.println("등록완료==>" + mu);
    }

    @Test
    public void delete() {
        mr.deleteById(2);
    }

    @Test
    public void select() {
        Optional<MyUser> optionalMyUser = mr.findById(1);
        if(!optionalMyUser.isEmpty()) {
            MyUser mu = optionalMyUser.get();
            System.out.println(mu);
        }else {
            System.out.println("존재하지 않는 유저 입니다.");
        }
    }

    @Test
    public void update() {
        MyUser mu = mr.findById(2).get();
        mu.setName("이길동");
        mu.setPhone("010-2222-2222");
        mu.setAddr("부산");
        System.out.println("수정완료");
    }
}
