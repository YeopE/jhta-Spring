package com.example.demo.controller;

import com.example.demo.service.FileInfomationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FileUploadController {
    private final FileInfomationService fileInfomationService;

    @Value("${file.path}")

    private String filePath;

    @GetMapping("/file/upload")
    public String uploadForm() {
        return "file/fileUpload";
    }

    @PostMapping("/file/upload")
    public String upload() {

        return "home";
    }
}
