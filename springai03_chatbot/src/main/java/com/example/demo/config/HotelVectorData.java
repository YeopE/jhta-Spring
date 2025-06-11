package com.example.demo.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

@Configuration
@RequiredArgsConstructor
public class HotelVectorData {
    private final VectorStore vectorStore;
    private final JdbcClient jdbcClient;

    @Value("classpath:/data.txt")
    Resource resource;

    @PostConstruct
    public void init() throws IOException{
        Integer count = jdbcClient.sql("select count(*) from vector_store")
                .query(Integer.class)
                .single();
        if(count == 0){
            Stream<String> stream = Files.lines(resource.getFile().toPath());
            List<Document> documents = stream.map(line->{
                return new Document(line);
            }).toList();
            TextSplitter textSplitter = new TokenTextSplitter();
            for(Document doc:documents){
                List<Document> splitDoc = textSplitter.split(doc);
                vectorStore.add(splitDoc);
            }
            System.out.println("벡터데이터로 저장 완료...");
        }
    }
}
