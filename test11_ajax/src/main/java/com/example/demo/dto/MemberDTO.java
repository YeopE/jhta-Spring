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

    public MemberDTO(Member mem) {
        this.id=mem.getId();
        this.pwd=mem.getPwd();
        this.email=mem.getEmail();
        this.age=mem.getAge();
        this.regdate=mem.getRegdate();
    }

    public Member toEntity() {
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
