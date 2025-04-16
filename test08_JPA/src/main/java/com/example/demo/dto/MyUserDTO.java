package com.example.demo.dto;

import com.example.demo.entity.MyUser;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Builder
public class MyUserDTO {
    @Id
    private int num;
    private String name;
    private String phone;
    private String addr;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    public MyUserDTO(MyUser user) {
        this.num=user.getNum();
        this.name=user.getName();
        this.phone=user.getPhone();
        this.addr=user.getAddr();
        this.createDate=user.getCreateDate();
        this.updateDate=user.getUpdateDate();
    }

    public MyUser toEntity() {
        MyUser mu = MyUser.builder()
                          .num(num)
                          .name(name)
                          .phone(phone)
                          .addr(addr)
                          .createDate(createDate)
                          .updateDate(updateDate)
                          .build();
        return mu;
    }
}
