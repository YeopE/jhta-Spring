package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude = {"movie"})
public class Comments {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnum;
    @ManyToOne
    @JoinColumn(name = "mnum")
    private Movie movie;
    private String id;
    private String comments;
}
