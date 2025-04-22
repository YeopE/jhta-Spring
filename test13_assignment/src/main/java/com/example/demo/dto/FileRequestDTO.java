package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileRequestDTO {
    private Long filenum;
    private String title;
    private MultipartFile file1;
    private Date regdate;
    private Date update;
}
