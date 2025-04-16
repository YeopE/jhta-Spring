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
public class GradeRepositoryTest {
    @Autowired
    private GradeRepository gr;
    @Autowired
    private StudentRepository sr;

    @Test
    public void save() {
        Optional<Student> student = sr.findById(2);
        Student s = student.get();
        gr.save(new Grade(0,s,"국어",100,"1학기"));
        gr.save(new Grade(0,s,"수학",85,"1학기"));
        gr.save(new Grade(0,s,"영어",90,"1학기"));
    }

    @Test
    public void findAll() {
        List<Grade> glist = gr.findAll();
        glist.forEach(e-> {
            System.out.println(e);
        });
    }

    @Test
    public void delete() {
        Grade g = gr.findById(6).get();
        gr.deleteById(g.getGnum());
//        gr.deleteById(6); //직접 번호로 바로 삭제 가능
    }

    @Test
    public void update() {
        Grade g = gr.findById(5).get();
        g.setScore(100);
        g.setSubject("국사");
        g.setSemester("2학기");
    }

}
