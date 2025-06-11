package com.example.demo.controller.chat1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//ChatClient ==> 역할 부여하기 (defaultSystem - 시스템메시지 설정)
@RestController
public class ChatController02 {
    private final ChatClient chatClient;
    public ChatController02(ChatClient.Builder builder) {
        this.chatClient=builder
                .defaultSystem("너는 할머니야. 할머니가 손주에게 이야기하듯이 설명해줘")
                .build();
    }

    @GetMapping("/chat02")
    public String getContent(@RequestParam("q") String q) {
        return chatClient.prompt()
                .user(q)
                .call()
                .content();
    }

}
