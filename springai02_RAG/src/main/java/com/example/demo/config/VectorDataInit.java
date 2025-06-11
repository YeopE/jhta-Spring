package com.example.demo.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class VectorDataInit {
    private final VectorStore vectorStore;
    private final JdbcClient jdbcClient;

    @Value("classpath:/과정안내서.pdf")
    private Resource pdfResource;

    // PDF파일을 읽어와서 VectorStore에 저장하기 (DB에 벡터데이터로 임베딩되어서 저장함)
    @PostConstruct
    public void init(){
        //vector_stroe에 데이터가 없으면 PDF문서를 임베딩해서 저장한다.

        //vector_store에 데이터가 존재하는지 검사
        Integer count = jdbcClient.sql("select count(*) from vector_store")
                .query(Integer.class)
                .single();

        if(count == 0) { //데이터가 없는 경우에만 임베딩해서 저장 - 한번만 저장되게 하기 위해
            PdfDocumentReaderConfig pdfDocumentReaderConfig = PdfDocumentReaderConfig.builder()
                    .withPagesPerDocument(1)
                    .withPageTopMargin(0)
                    .withPageBottomMargin(0)
                    .build();
            PagePdfDocumentReader pdfDocumentReader = new PagePdfDocumentReader(pdfResource, pdfDocumentReaderConfig);
            //PDF문서를 읽어와 List로 만들기
            List<Document> documents = pdfDocumentReader.get();
            TokenTextSplitter splitter = new TokenTextSplitter(1000, 400, 10, 5000,true);

            //Chunk단위로 분리된 Document객체 List로 얻어오기
            List<Document> splitDocuments = splitter.apply(documents);
            //vectorStore에 저장하기 - db에 벡터데이터로 저장된다.
            vectorStore.accept(splitDocuments);
            System.out.println("벡터데이터로 저장 완료...........");
        }
    }
}
