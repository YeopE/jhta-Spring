package com.example.demo.dto;


import com.example.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberDTO {
    private String id;
    private String pwd;
    private String email;
    private int age;
    private Date regdate;

    public MemberDTO(Member mem) { //엔티티 객체를 DTO객체로 변환
        this.id=mem.getId();
        this.pwd=mem.getPwd();
        this.email=mem.getEmail();
        this.age=mem.getAge();
        this.regdate=mem.getRegdate();
    }

    public Member toEntity() { //DTO 객체를 엔티티 객체로 변환
//        Member m = new Member(id, pwd, email, age, regdate);
        //객체 생성시 위가 아닌 아래의 빌더패턴으로 많이 사용한다.
        Member m = Member.builder()
                         .id(id)
                         .pwd(pwd)
                         .email(email)
                         .age(age)
                         .regdate(regdate)
                         .build();
        return m;
    }
}
