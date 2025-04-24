package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreResponse {
    private Long studentId;
    private String name;
    private Integer age;
    private Long scoreId;
    private String subject;
    private Integer score;
}
