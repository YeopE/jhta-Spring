package com.example.demo.controller;

import com.example.demo.dto.FileinfoDTO;
import com.example.demo.service.FileinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class FiledownloadController {
    private final FileinfoService fileinfoService;

    @Value("${file.path}")
    private String filepath;

    @GetMapping("/file/download")
    public ResponseEntity<Resource> download(@RequestParam("filenum") long filenum) throws MalformedURLException {
        FileinfoDTO dto = fileinfoService.select(filenum);
        String savefilename = dto.getSavefilename();
        String orgfilename = dto.getOrgfilename();
        //파일명이 한글이 깨지지 않도록 인코딩
        String filename = UriUtils.encode(orgfilename, StandardCharsets.UTF_8);
        UrlResource resource = new UrlResource("file:" + filepath + File.separator + savefilename);
        String contentDisposition = "attachment;filename=\"" + filename + "\"";
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition)
                .body(resource);
    }
}
