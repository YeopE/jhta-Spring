package com.example.demo.repository;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository sr;

    @Autowired
    private GradeRepository gr;

    @Test
    public void save() {
        sr.save(new Student(0,"홍길동","010-1111-1111"));
        sr.save(new Student(0,"이길동","010-2222-2222"));
        sr.save(new Student(0,"삼길동","010-3333-3333"));
    }

    @Test
    public void update() {
        Student student = sr.findById(1).get();
        student.setName("일길동");
        student.setTel("010-1234-1234");
        System.out.println("학생정보 수정완료");
    }

    @Test
    public void delete() {
        sr.deleteById(3);
    }

    @Test
    public void List() {
        List<Student> list = sr.findAll();
        list.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void selectList1() {
        List<Student> s = sr.findByName("이길동");
        s.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void find() {
        List<Student> s = sr.findByNameOrTel("이길동","010-1234-1234");
        s.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void find2() {
        List<Student> s = sr.findByNameContaining("길");
        s.forEach(e->{
            System.out.println(e);
        });
    }


    @Test
    public void gradeList() {
        List<Grade> list = gr.findByScoreGreaterThanEqual(50);
        list.forEach(e->{
            System.out.println(e);
        });
    }

}
