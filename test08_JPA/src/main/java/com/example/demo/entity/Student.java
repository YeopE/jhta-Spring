package com.example.demo.entity;
/*
    학생번호,이름,전화번호 정보를 갖는 테이블을 작성하고 CRUD작업 해보기

    학생테이블을 참조하는 성적테이블을 만들고 데이터 저장 후 학생 성적 조회하기
    성적테이블(성적번호,학생번호,과목명,점수,학기)
    1학기 성적조회(학생번호,이름,과목명,점수)
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int snum;
    private String name;
    private String tel;
}
