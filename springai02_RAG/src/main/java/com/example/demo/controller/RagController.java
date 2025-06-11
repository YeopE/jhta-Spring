package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RagController {
    private final ChatModel chatModel;
    private final VectorStore vectorStore;

    private String promptMsg = """
            질문에 답변하는 것입니다. 질문에 정확하게 답변하기 위해 문서에 있는 정보를 사용해야 합니다.
            만약 정보가 부족하거나 문서에서 답을 찾을 수 없으면 모른다고 답변하세요.
            질문:
            {input}
            문서:
            {documents}
            """;

    @GetMapping("/rag")
    public String similarText(@RequestParam("q") String q) {
        List<Document> documentList = vectorStore.similaritySearch(SearchRequest.builder()
                .query(q) //질의
                .topK(5) //상위 5개의 결과값 얻어오기
                .build());
        String documents = documentList.stream().map(doc->doc.getText()).collect(Collectors.joining());

        PromptTemplate promptTemplate = new PromptTemplate(promptMsg);
        Map<String, Object> params = new HashMap<>();
        params.put("input", q);
        params.put("documents", documents);

        return chatModel.call(promptTemplate.create(params)).getResult().getOutput().getText();
    }
}
