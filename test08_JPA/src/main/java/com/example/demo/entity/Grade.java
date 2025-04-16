package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gnum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snum")
    private Student student;
    private String subject;
    private int score;
    private String semester;
}
