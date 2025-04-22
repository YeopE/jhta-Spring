package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileInfomation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filenum;
    private String title;
    private String orgfilename;
    private String savefilename;
    private long filesize;
    @CreationTimestamp
    private Date regdate;
    @UpdateTimestamp
    private Date update;
}
