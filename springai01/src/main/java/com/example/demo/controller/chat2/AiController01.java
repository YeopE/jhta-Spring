package com.example.demo.controller.chat2;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai01")
public class AiController01 {
    @Autowired
    private ChatModel chatModel;

    @GetMapping("/chat01")
    public String getContent(@RequestParam("question") String question){
        // return chatModel.call(question); // 단순메시지 출력시 사용
        ChatResponse resp = chatModel.call(new Prompt(
                question, // 사용자 메시지
                OpenAiChatOptions.builder() // 옵션
                        .temperature(0.5) // 0.0 ~ 1.0 ==> 1로 가까워질수록 창의적인 대답, 0으로 가까워질수록 정확한 대답
                        .model("gpt-4o")
                        .build()
        ));
        return resp.getResult().getOutput().getText();
    }
}
