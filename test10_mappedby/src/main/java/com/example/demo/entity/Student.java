package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString (exclude = "grades")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int snum;
    private String name;
    private String phone;
    //mappedBy : 연관관계의 주체(FK를 갖는 엔티티-자식테이블) 설정
    //CascadeType.All : 값을 추가하면 자식테이브렝 같이 추가됨
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL) //실제 가지고 있는게 아니라 mapping을 하여 읽어온다.

    private List<Grade> grades = new ArrayList<>();

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


}
