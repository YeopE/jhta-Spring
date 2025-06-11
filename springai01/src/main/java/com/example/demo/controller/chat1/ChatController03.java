package com.example.demo.controller.chat1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat03")
//시스템메시지에 placeholder 사용해보기
public class ChatController03 {

    private final ChatClient chatClient;

    private String promptMsg = """
                너는 {who}야.
                답변을 {tone}하게 설명해줘
                """;

    public ChatController03(ChatClient.Builder builder) {
        this.chatClient=builder
                    .defaultSystem(promptMsg)
                    .build();
    }
    @GetMapping("/q1")
    public String getContent(@RequestParam("q") String q,
                             @RequestParam("who") String who,
                             @RequestParam("tone") String tone) {
        return chatClient.prompt()
                .system(sp->{
                    //시스템메시지에 placeholder 지정하기
                          sp.param("who", who)
                            .param("tone", tone);
                })
                .user(q)
                .call()
                .content();
    }
}
