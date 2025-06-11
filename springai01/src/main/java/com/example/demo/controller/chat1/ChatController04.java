package com.example.demo.controller.chat1;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Movie;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat04")
public class ChatController04 {
    private final ChatClient chatClient;

    public ChatController04(ChatClient.Builder builder) {
        this.chatClient=builder.build();
    }

    @GetMapping("/q1") // 사과에 대해서 알려줘
    public Answer getContent(@RequestParam("q") String q){
        Answer answer = chatClient.prompt()
                            .user(q)
                            .call()
                            .entity(Answer.class);
        return answer;
    }
    @GetMapping("/q2") // 과일의 종류가 뭐가 있어? (배열 형태의 답을 받을 수 있도록 질문)
    public List<String> getContent1(@RequestParam("q") String q) {
        List<String> result = chatClient.prompt()
                .user(q)
                .call()
                .entity(new ListOutputConverter(new DefaultConversionService()));
        return result;
    }

    @GetMapping("/q3")
    //10개의 나라와 그 나라의 수도를 알려줘
    public Map<String, String> getContent3(@RequestParam("q") String q){
        //컨버터를 사용해서 Map형태의 데이터 받아오기
        return chatClient.prompt()
                .user(q)
                .call()
                .entity(new ParameterizedTypeReference<Map<String, String>>() {});
    }
    
    @GetMapping("/q4")
    //10개의 영화제목과 감독을 알려줘
    public List<Movie> getContent7(@RequestParam("q") String q) {
        return chatClient.prompt()
                .user(q)
                .call()
                .entity(new ParameterizedTypeReference<List<Movie>>() {
                });
    }
}
