package com.example.test18_miniproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNum;
    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false)
    private String pwd;
    private String phone;
    private String email;
    private String addr;
    @Builder.Default
    private String role = "MEMBER";
    @CreationTimestamp
    private Date regdate;
}
