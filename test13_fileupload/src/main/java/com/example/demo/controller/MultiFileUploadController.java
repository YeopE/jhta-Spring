package com.example.demo.controller;

import com.example.demo.dto.FileinfoDTO;
import com.example.demo.dto.MultiFileRequestDTO;
import com.example.demo.service.FileinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MultiFileUploadController {
    private final FileinfoService fileinfoService;
    @Value("${file.path}")
    private String filePath;

    @GetMapping("/file/uploadFiles")
    public void uploadForm() {

    }

    @PostMapping("/file/uploadFiles")
    public String upload(MultiFileRequestDTO dto) {
        //다중파일 업로드 코드 완성해 보세요.
        List<MultipartFile> fileList = dto.getFile1();
//        File f = new File(filePath);
//        if(!f.exists()) f.mkdirs();

        fileList.forEach(f->{
            //전송된 파일명
            String orgfilename = f.getOriginalFilename();
            //저장할 파일명
            String savefilename = UUID.randomUUID() + "_" + orgfilename;
            //transferTo 메소드로 저장
            File ff = new File(filePath + File.separator + savefilename);
            System.out.println("파일업로드 완료! 저장된 파일명 >>" + savefilename);
            try {
                f.transferTo(ff);
            }catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        });
        return "result";
    }
}
