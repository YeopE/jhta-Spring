package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MyUserRepositoryTest {
    @Autowired
    private MyUserRepository myUserRepository;

//    @Test
//    public void insert() {
//        MyUser myUser = new MyUser(1,"홍길동","010-1111-1111","서울");
//        myUserRepository.insert(myUser);
//    }

    @Test
    public void select() {
        MyUser myUser = myUserRepository.find(1);
        System.out.println(myUser);
    }

//    @Test
//    public void update() {
//        myUserRepository.update(new MyUser(1,"일길동","010-1234-1234","부산"));
//    }

    @Test
    public void delete() {
        myUserRepository.delete(1);
    }


}
