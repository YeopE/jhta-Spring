package com.example.test18_miniproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"member1"})
@Builder
public class Board1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNum")
    private Member1 member1;
    private String title;
    @Lob
    private String content;
    private String filename1;
    private String filename2;
    private String filename3;
    @CreationTimestamp
    private LocalDateTime regdate;
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
