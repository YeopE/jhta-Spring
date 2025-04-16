package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class My_userRepositoryTest {
    @Autowired
    private My_userRepository mr;

    @Test
    public void save() {
        mr.save(new MyUser(1,"홍길동","010-1234-1234","서울시",null,null));
        mr.save(new MyUser(2,"이길동","010-2222-2222","서울시",null,null));
    }

    @Test
    public void selectAll() {
        mr.findAll().forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void update() {
        MyUser u = mr.findById(1).get();
        u.setName("일길동");
        u.setPhone("010-1111-1111");
        System.out.println("수정완료");
    }
}
