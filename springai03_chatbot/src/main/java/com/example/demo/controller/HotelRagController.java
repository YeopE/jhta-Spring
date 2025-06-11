package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelRagController {
    private final VectorStore vectorStore;
    private final ChatClient chatClient;
    
    @GetMapping("/hotelQ")
    public String answer(@RequestParam("question") String question){
        List<Document> results = vectorStore.similaritySearch(SearchRequest.builder()
                        .topK(1)
                        .query(question)
                        .similarityThreshold(0.5) //유사도가 0으로 갈수록 정확하게 1로 갈수록 유연하게
                .build());
        String template = """
                    당신은 어느 호텔직원입니다. 문맥에 따라 고객의 질문에 답변해 주세요.
                    컨텍스트가 질문에 대답할 수 없는 경우는 모른다고 대답하세요.
                    컨텍스트:
                    {content}
                    질문:
                    {question}
                """;
        return chatClient.prompt()
                .user(promptUserSpec -> {
                    promptUserSpec.text(template)
                            .param("content", results)
                            .param("question", question);
                }).call().content();
    }

    @GetMapping("/hotelQ1")
    public Flux<String> answer1(@RequestParam("question") String question){
        List<Document> results = vectorStore.similaritySearch(SearchRequest.builder()
                .topK(1)
                .query(question)
                .similarityThreshold(0.5) //유사도가 0으로 갈수록 정확하게 1로 갈수록 유연하게
                .build());
        String template = """
                    당신은 어느 호텔직원입니다. 문맥에 따라 고객의 질문에 답변해 주세요.
                    컨텍스트가 질문에 대답할 수 없는 경우는 모른다고 대답하세요.
                    컨텍스트:
                    {content}
                    질문:
                    {question}
                """;
        return chatClient.prompt()
                .user(promptUserSpec -> {
                    promptUserSpec.text(template)
                            .param("content", results)
                            .param("question", question);
                }).stream().content();
    }
}
