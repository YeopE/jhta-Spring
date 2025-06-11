package com.example.demo.controller.chat1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController01 {

    private final ChatClient chatClient;

    public ChatController01(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/chat1")
    public String getContent(@RequestParam("question") String question){
        String result = chatClient.prompt() // 프롬프트 생성
                                .user(question) // 사용자 메시지 생성
                                .call() // LLM 요청
                                .content(); // 요청결과를 String으로 받기
                    return result;
    }
}
