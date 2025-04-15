package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity //이 클래스가 테이블과 매핑된다는 것을 알려줌
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name="Members") //테이블명 변경시 사용하는 어노테이션
public class Member {
    @Id //PK가 되는 컬럼을 의미
    private String id;
    @Column(name="pwd") //Column의 이름 변경시 사용하는 어노테이션
    private String password;
    private int age;
    private String email;
}


