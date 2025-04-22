package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MultiFileRequestDTO {
    private Long filenum;
    private String writer;
    private String title;
    private String content;
    //전송된 파일에 대한 정보를 갖는 객체
    private List<MultipartFile> file1; //upload.html에 input file의 name과 동일해야한다.
}
