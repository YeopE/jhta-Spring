package com.example.test18_miniproject.controller.board;

import com.example.test18_miniproject.dto.Board1DTO;
import com.example.test18_miniproject.dto.FileRequestDTO;
import com.example.test18_miniproject.security.CustomUserDetails;
import com.example.test18_miniproject.service.Board1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BoardInsertController {
    private final Board1Service board1Service;

    @Value("${file.path}")
    private String filePath;

    @GetMapping("/member/boardInsert")
    public String insertForm(FileRequestDTO fileRequestDTO){

        return "board/boardInsert";
    }

    @PostMapping("/member/boardInsert")
    public String insert(@ModelAttribute FileRequestDTO dto,
                         @AuthenticationPrincipal CustomUserDetails userDetails) {

        List<MultipartFile> files = dto.getFileList();
        String filename1 = null;
        String filename2 = null;
        String filename3 = null;

        for(int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if(!file.isEmpty()){
                String originalName = file.getOriginalFilename();
                String saveName = UUID.randomUUID() + "_" + originalName;

                try {
                    file.transferTo(new File(filePath + File.separator + saveName));
                }catch (IOException e) {
                    e.printStackTrace();
                }

                if(i == 0) filename1 = saveName;
                else if(i == 1) filename2 = saveName;
                else if(i == 2) filename3 = saveName;
            }
        }

        Board1DTO boardDTO = Board1DTO.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .filename1(filename1)
                .filename2(filename2)
                .filename3(filename3)
                .member1(userDetails.getMember1()) // 또는 직접 조회
                .build();
        board1Service.insert(boardDTO);

        return "redirect:/boardList";
    }
}
