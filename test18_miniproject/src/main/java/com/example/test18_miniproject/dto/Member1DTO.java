package com.example.test18_miniproject.dto;

import com.example.test18_miniproject.entity.Member1;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member1DTO {
    private Long idNum;
    private String id;
    private String pwd;
    private String phone;
    private String email;
    private String addr;
    private String role;
    private Date regdate;

    public Member1DTO(Member1 mem){
        this.idNum = mem.getIdNum();
        this.id = mem.getId();
        this.pwd = mem.getPwd();
        this.phone = mem.getPhone();
        this.email = mem.getEmail();
        this.addr = mem.getAddr();
        this.role = mem.getRole();
        this.regdate = mem.getRegdate();
    }

    public Member1 toEntity(){
        Member1 mem = Member1.builder()
                .idNum(idNum)
                .id(id)
                .pwd(pwd)
                .phone(phone)
                .email(email)
                .addr(addr)
                .role(role == null ? "MEMBER" : role)
                .regdate(regdate)
                .build();
        return mem;
    }
}
