package com.example.demo.controller;

import com.example.demo.dto.FileinfoDTO;
import com.example.demo.service.FileinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FileListController {
    private final FileinfoService fileinfoService;

    @GetMapping("/file/list")
    public String list(Model model) {
        List<FileinfoDTO> list = fileinfoService.list();
        model.addAttribute("list", list);

        return "/file/list";
    }

    //요청경로와 viewPage의 경로가 동일하면 void를 사용하면 자동으로 경로를 찾아간다.
//    @GetMapping("/file/list")
//    public void list(Model model) { //return type이 void이면 요청경로가 이동할 뷰이름이 된다.
//        List<FileinfoDTO> list = fileinfoService.list();
//        model.addAttribute("list", list);
//    }
}
