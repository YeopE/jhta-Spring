package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Builder
public class MyUser {
    @Id
    private int num;
    private String name;
    private String phone;
    private String addr;
    //등록일
    @CreatedDate //생성시 자동 날짜 저장
    private LocalDateTime createDate;
    //수정일
    @LastModifiedDate //수정시 자동 날짜 수정
    private LocalDateTime updateDate;
}
