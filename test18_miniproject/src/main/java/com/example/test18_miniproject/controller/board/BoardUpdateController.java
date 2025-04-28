package com.example.test18_miniproject.controller.board;

import com.example.test18_miniproject.dto.Board1DTO;
import com.example.test18_miniproject.dto.FileRequestDTO;
import com.example.test18_miniproject.service.Board1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BoardUpdateController {
    private final Board1Service board1Service;

    @Value("${file.path}")
    private String filePath;

    @GetMapping("/board/update")
    public String updateForm(@RequestParam("postNum")Long postNum,
                             Model model) {
        Board1DTO board1DTO = board1Service.select(postNum);
        model.addAttribute("dto", board1DTO);

        return "board/boardUpdate";
    }

    @PostMapping("/board/update")
    public String update(@ModelAttribute FileRequestDTO dto){
        Board1DTO board1DTO = board1Service.select(dto.getPostNum());

        List<MultipartFile> files = dto.getFileList();
        String filename1 = board1DTO.getFilename1();
        String filename2 = board1DTO.getFilename2();
        String filename3 = board1DTO.getFilename3();

        for(int i = 0; i < files.size(); i++){
            MultipartFile file = files.get(i);
            if(!file.isEmpty()) {
                String oldFilename = (i == 0) ? filename1 : (i == 1) ? filename2 : filename3;
                if(oldFilename != null) {
                    File oldFile = new File(filePath + File.separator + oldFilename);
                    if(oldFile.exists()){
                        oldFile.delete();
                    }
                }

                String originalName = file.getOriginalFilename();
                String saveName = UUID.randomUUID() + "_" + originalName;
                File newFile = new File(filePath + File.separator + saveName);
                try {
                    file.transferTo(newFile);
                }catch (IOException e) {
                    e.printStackTrace();
                }

                if (i == 0) filename1 = saveName;
                else if (i == 1) filename2 = saveName;
                else if (i == 2) filename3 = saveName;
            }
        }
        Board1DTO updateDTO = Board1DTO.builder()
                .postNum(dto.getPostNum())
                .title(dto.getTitle())
                .content(dto.getTitle())
                .filename1(filename1)
                .filename2(filename2)
                .filename3(filename3)
                .member1(board1DTO.getMember1())
                .build();

        board1Service.update(updateDTO);

        return "redirect:/boardList";
    }
}
