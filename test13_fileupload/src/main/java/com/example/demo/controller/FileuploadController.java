package com.example.demo.controller;

import com.example.demo.dto.FileRequestDTO;
import com.example.demo.dto.FileinfoDTO;
import com.example.demo.service.FileinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class FileuploadController {
    private final FileinfoService fileinfoService;

    //application.properties파일에 설정된 값 읽어오기
    @Value("${file.path}")
    private String filepath; //c:\\upload

    @GetMapping("/file/upload")
    public String uploadForm() {
        return "file/upload";
    }

    @PostMapping("/file/upload")
    public String uploadOk(FileRequestDTO requestDTO) { //FileRequestDTO의 정보를 파라미터로 받아온다.
        MultipartFile file1 = requestDTO.getFile1();
        File f = new File(filepath);
        if(!f.exists()) f.mkdirs(); // c:\\upload폴더가 없으면 폴더 생성하기
        //전송된 파일명
        String orgFileName = file1.getOriginalFilename();
        //저장할 파일명(중복되지 않는 파일명 만들기)
        String saveFileName = UUID.randomUUID() + "_" + orgFileName;
        long fileSize = file1.getSize(); //파일크기
        File ff = new File(filepath + File.separator + saveFileName);
        try {
            file1.transferTo(ff);//파일 복사하기
            System.out.println("파일업로드 완료!");
            //DB에 파일정보 저장
            FileinfoDTO dto = FileinfoDTO.builder()
                    .writer(requestDTO.getWriter())
                    .title(requestDTO.getTitle())
                    .content(requestDTO.getContent())
                    .orgfilename(orgFileName)
                    .savefilename(saveFileName)
                    .filesize(fileSize)
                    .build();
            fileinfoService.insert(dto);
        }catch (IOException ie) {
            System.out.println(ie.getMessage());
        }

        return "result";
    }
}
