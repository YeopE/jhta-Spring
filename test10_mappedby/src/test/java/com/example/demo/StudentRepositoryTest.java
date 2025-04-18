package com.example.demo;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.repository.GradeRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository sr;
    @Autowired
    private GradeRepository gr;

    @Test
    public void save() {
        Student s = new Student("홍길동", "010-1234-1234");
        sr.save(s);
        Student s1 = new Student("이길동", "010-2222-2222");
        sr.save(s1);
    }

    @Test
    public void saveGrade() {
        Student s = sr.findById(1).get();
        gr.save(new Grade(0, s, "국어", 100));
        gr.save(new Grade(0, s, "수학", 90));

        Student s1 = sr.findById(2).get();
        gr.save(new Grade(0, s1, "국어", 80));
        gr.save(new Grade(0, s1, "수학", 95));
    }


    @Test
    public void printAll() {
        List<Student> slist = sr.findAll();
        for (Student s : slist) {
            System.out.println("학생번호:" + s.getSnum());
            System.out.println("학생이름:" + s.getName());
            System.out.println("<< 성적표 >>");
            List<Grade> glist = s.getGrades(); //LAZY를 사용했기 때문에 Grades를 사용해서 꺼내와야한다.
            for (Grade g : glist) {
                System.out.println("과목명:" + g.getSubject());
                System.out.println("점수:" + g.getScore());
            }
            System.out.println();
        }
    }

    @Test
    public void save1() {
        Student s = new Student("삼길동", "010-3333-3333");
        ArrayList<Grade> list = (ArrayList<Grade>) s.getGrades();
        list.add(new Grade(0, s, "국어", 100));
        list.add(new Grade(0, s, "수학", 100));
        sr.save(s); //CascadeType.All옵션을 지정했기 때문에 Grade테이블에도 값이 같이 등록된다.
    }

    @Test
    public void printGrade() {
//        List<Grade> grade = gr.list1(); // student를 사용하지 않아 값을 student를 불러오지 않는다.
//        List<Grade> grade = gr.list2(); //fetch join 사용 (student를 사용하지 않아도 student의 값을 가져옴.)
        List<Grade> grade = gr.list3(); //어노테이션 EntityGraph를 이용하여 join
        for (Grade g : grade) {
            System.out.println("성적번호:" + g.getGnum());
            System.out.println("학생번호:" + g.getStudent().getSnum());
            System.out.println("과목:" + g.getSubject());
            System.out.println("점수:" + g.getScore());
            System.out.println();
        }
    }

}