package com.example.demo.service;

import com.example.demo.model.QScore;
import com.example.demo.model.QStudent;
import com.example.demo.model.Student;
import com.example.demo.model.StudentScoreResponse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScoreCustomService {
    private final JPAQueryFactory queryFactory;
    private final QStudent st = QStudent.student;
    private final QScore sc = QScore.score1;

    public Student getInfo1(Long studentId){
        //select * from student where studentid = 1
        Student s = queryFactory
                    .selectFrom(st)
                    .where(st.studentId.eq(studentId))
                    .fetchOne(); //하나
        return s;
    }

    public List<Student> getInfo2(String name){
        List<Student> list = queryFactory
                            .selectFrom(st)
                            .where(st.name.eq(name))
                            .fetch(); //여러개
        return list;
    }

    public List<Student> getInfo3(int age) {
        return queryFactory.selectFrom(st)
                            .where(st.age.goe(age)) //goe 크거나 같다.
                            .fetch();
    }

    public List<Student> getInfo4(String name,Long studentId){
        BooleanBuilder predicate = new BooleanBuilder();
        if(name!=null) {
            predicate.or(st.name.eq(name)); //or 연산자
        }
        if(studentId!=null){
            predicate.or(st.studentId.eq(studentId));
        }
        return queryFactory.selectFrom(st)
                            .where(predicate)
                            .fetch();
    }

    //join
    public List<StudentScoreResponse> getList1(){
        //Tuple에 담아준 후
        List<Tuple> list = queryFactory.select(st.studentId,st.name,st.age,sc.scoreId,sc.subject,sc.score)
                                        .from(st)
                                        .join(sc)
                                        .on(st.studentId.eq(sc.scoreId))
                                        .fetch();
        //다시 변환하여 StudentScoreResponse에 담아준다.
        // fetch메소드는 조인한 결과를 List<Tuple>타입으로 반환한다.->map을 이용해서 원하는 DTO타입으로 변경한다.
        List<StudentScoreResponse> result = list.stream().map(t->{
            return StudentScoreResponse.builder()
                    .studentId(t.get(st.studentId))
                    .name(t.get(st.name))
                    .age(t.get(st.age))
                    .scoreId(t.get(sc.scoreId))
                    .subject(t.get(sc.subject))
                    .score(t.get(sc.score))
                    .build();
        }).toList();
        return result;
    }

    public List<StudentScoreResponse> getList2(){
        //Projections : 쿼리 결과를 원하는객체나 값으로 변화해 주는 기능을 하는 클래스
        List<StudentScoreResponse> list = queryFactory.select(Projections.bean(
                                            StudentScoreResponse.class,
                                            st.studentId,
                                            st.name,
                                            st.age,
                                            sc.scoreId,
                                            sc.subject,
                                            sc.score))
                                        .from(st)
                                        .leftJoin(sc)
                                        .on(st.studentId.eq(sc.studentId))
                                        .orderBy(sc.score.desc())
                                        .fetch();
        return list;
    }
}
