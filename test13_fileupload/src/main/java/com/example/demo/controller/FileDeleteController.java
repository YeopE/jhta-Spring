package com.example.demo.controller;

import com.example.demo.dto.FileinfoDTO;
import com.example.demo.service.FileinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
@RequiredArgsConstructor
public class FileDeleteController {
    private final FileinfoService fileinfoService;
    @Value("${file.path}")
    private String filepath;

    @GetMapping("/file/delete")
    public String fileDelete(@RequestParam("filenum")Long filenum) {

        FileinfoDTO dto = fileinfoService.select(filenum);

        File file = new File(filepath + File.separator + dto.getSavefilename());
        if(file.exists()) file.delete();

        fileinfoService.delete(filenum);

        return "redirect:/file/list";
    }
}
