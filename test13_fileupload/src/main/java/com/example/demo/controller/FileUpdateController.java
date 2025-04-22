package com.example.demo.controller;

import com.example.demo.dto.FileRequestDTO;
import com.example.demo.dto.FileinfoDTO;
import com.example.demo.service.FileinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class FileUpdateController {
    private final FileinfoService fileinfoService;

    @Value("${file.path}")
    private String filePath;

    @GetMapping("/file/update")
    public void updateForm(@RequestParam("filenum")Long filenum,
                           Model model) {
        FileinfoDTO dto = fileinfoService.select(filenum);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/file/update")
    public String update(FileRequestDTO dto){
        FileinfoDTO fileinfo = fileinfoService.select(dto.getFilenum());
        MultipartFile file1 = dto.getFile1();
        if(!file1.isEmpty()){ //수정할 파일이 전송된 경우
            //기존 파일 삭제
            File f = new File(filePath + File.separator + fileinfo.getSavefilename());
            if(f.exists() && f.delete()){
                System.out.println("파일삭제 완료...");
            }
            String orgfilename = file1.getOriginalFilename(); //새롭게 전송된 파일명
            String savefilename = UUID.randomUUID() + "_" + orgfilename;
            File destFile = new File(filePath + File.separator + savefilename);
            try {
                file1.transferTo(destFile); //새로운 파일로 업로드 하기
                long filesize = file1.getSize();
                FileinfoDTO newfileDTO = FileinfoDTO.builder()
                        .filenum(dto.getFilenum())
                        .title(dto.getTitle())
                        .writer(dto.getWriter())
                        .content(dto.getContent())
                        .orgfilename(orgfilename)
                        .savefilename(savefilename)
                        .filesize(filesize)
                        .build();
                fileinfoService.update(newfileDTO);
            }catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }else {//수정할 파일이 전송되지 않은 경우
            // 전송된 정보로 update 하지만 파일은 기존 정보를 유지
            FileinfoDTO updateDTO = FileinfoDTO.builder()
                    .filenum(dto.getFilenum())
                    .title(dto.getTitle())
                    .writer(dto.getWriter())
                    .content(dto.getContent())
                    .orgfilename(fileinfo.getOrgfilename())
                    .savefilename(fileinfo.getSavefilename())
                    .filesize(fileinfo.getFilesize())
                    .build();
            fileinfoService.update(updateDTO);
        }
        return "result";
    }
}
