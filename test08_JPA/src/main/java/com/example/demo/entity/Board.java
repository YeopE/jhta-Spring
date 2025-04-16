package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment로 자동 저장되도록
    private Long num;
    @ManyToOne(fetch = FetchType.LAZY)
    //LAZY는 실제로 접근할 DB조회 EAGER는 연관 객체 모두 조회 (일반적으로는 LAZY를 사용한다.)
    @JoinColumn(name="id")
    private Member member;
    private String title;
    @Lob //longtext 많은 양의 문자 저장
    private String content;
    @CreationTimestamp //save 메소드로 저장할 때 해당 시점의 날짜의 정보 자동 저장
    private Date regDate;
}
