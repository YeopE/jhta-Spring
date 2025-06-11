package com.example.demo.controller.chat2;

import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.content.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class AiImageAnalysis03 {
    @Value("${uploads}")
    private String upload;
    @Autowired
    private ChatModel chatModel;

    @PostMapping("/analysis")
    public String getAnalysis(@RequestParam("file1")MultipartFile file,
                              @RequestParam("msg") String msg){
        File f = new File(upload);
        if(!f.exists()) f.mkdirs(); //업로드할 디렉토리 생성
        String filename = file.getOriginalFilename(); //전송된 파일명 얻어오기
        Path filePath = Paths.get(upload, filename);
        try {
            Files.write(filePath,file.getBytes()); //업로드된 파일을 filepath에 쓰기(파일복사)
            System.out.println("파일업로드 완료.....");

            Media media = new Media(
                            MimeType.valueOf(file.getContentType()),
                            file.getResource());
            UserMessage userMessage = UserMessage.builder()
                    .media(media)
                    .text(msg)
                    .build();
            var systemMsg = new SystemMessage("당신은 분석가입니다. 이미지를 분석해서 설명해 주세요.");
            return chatModel.call(userMessage,systemMsg);
        }catch (IOException ie) {
            System.out.println(ie.getMessage());
            return "이미지를 분석할 수 없습니다...";
        }
    }
}
