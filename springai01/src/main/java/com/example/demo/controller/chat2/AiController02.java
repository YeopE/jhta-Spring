package com.example.demo.controller.chat2;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController02 {
    @Autowired
    private OpenAiImageModel openAiImageModel;

    @PostMapping("/makeImage")
    public String getImages(@RequestParam("desc") String desc) {
        ImageResponse resp = openAiImageModel.call(
                    new ImagePrompt(
                        desc, // 생성할 이미지에 대한 설명(사용자 메시지)
                        OpenAiImageOptions.builder() // 생성할 이미지 옵션
                                .quality("hd")
                                .N(1)
                                .height(1024)
                                .width(1024)
                                 .build()
                    )
        );
        return resp.getResult().getOutput().getUrl(); // 생성된 이미지의 url을 String으로 리턴
    }
}
