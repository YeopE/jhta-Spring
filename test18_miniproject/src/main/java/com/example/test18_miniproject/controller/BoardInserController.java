package com.example.test18_miniproject.controller;

import com.example.test18_miniproject.dto.FileRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardInserController {

    @GetMapping("/member/boardInsert")
    public String insertForm(FileRequestDTO fileRequestDTO){


        return "board/boardInsert";
    }
}
