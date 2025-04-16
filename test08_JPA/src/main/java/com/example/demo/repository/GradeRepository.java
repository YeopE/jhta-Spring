package com.example.demo.repository;

import com.example.demo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    // 점수가 60점 이상인 성적 조회

    @Query("select g from Grade  g join g.student s")
    List<Grade> list();

    List<Grade> findByScoreGreaterThanEqual(int score);

}
