package com.example.test18_miniproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;

@RestController
public class DataUrlController {
    @Value("${file.path}")
    private String filepath;

    @GetMapping("/images/{filename}")
    public UrlResource showImage(@PathVariable("filename")String filename) throws MalformedURLException {
        System.out.println("요청받은 파일:" + filename);
        return new UrlResource("file:" + filepath + File.separator + filename);
    }
}
