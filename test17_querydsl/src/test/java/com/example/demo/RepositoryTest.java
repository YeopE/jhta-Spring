package com.example.demo;

import com.example.demo.model.Score;
import com.example.demo.model.Student;
import com.example.demo.repository.ScoreRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ScoreCustomService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class RepositoryTest {
    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private ScoreCustomService scoreCustomService;

    @Test
    public void save() {
        for(int i = 1; i <= 10; i++) {
            Student student = new Student((long)i,"길동" + i,(int)(i*10));
            studentRepository.save(student);
            Score score = new Score((long)i,"kor"+2,i*10,(long)i);
            scoreRepository.save(score);
        }
        System.out.println("완료!");
    }

    @Test
    public void getinfo(){
        Student s = scoreCustomService.getInfo1(1L);
        System.out.println("조회된 학생 ==>" + s);
    }

    @Test
    public void getinfo2(){
        List<Student> list = scoreCustomService.getInfo2("길동1");
        list.forEach(s->{
            System.out.println(s);
        });
    }

    @Test
    public void getinfo3(){
        List<Student> list = scoreCustomService.getInfo3(50);
        list.forEach(s->{
            System.out.println(s);
        });
    }

    @Test
    public void getinfo4(){
    //    List<Student> list = scoreCustomService.getInfo4("길동1", 8L);
        List<Student> list = scoreCustomService.getInfo4(null, 8L); //null은 조회하지 않아서 or을 제외하고 studentId값만으로 조회한다.
        list.forEach(s-> System.out.println(s));
    }

    @Test
    public void getList1() {
        scoreCustomService.getList1().forEach(s->{
            System.out.println(s);
        });
    }

    @Test
    public void getList2() {
        scoreCustomService.getList2().forEach(s->{
            System.out.println(s);
        });
    }

}
