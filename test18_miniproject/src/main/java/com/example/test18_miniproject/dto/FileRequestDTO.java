package com.example.test18_miniproject.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileRequestDTO {
    private Long postNum;
    private String member1;
    private List<MultipartFile> fileList;
}
