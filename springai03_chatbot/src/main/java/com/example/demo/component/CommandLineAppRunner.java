package com.example.demo.component;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//@Component
public class CommandLineAppRunner implements CommandLineRunner {
    //@Autowired
    private ChatClient chatClient;

    @Override
    public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("질문할 내용을 입력하세요.");
        while (true){
            String q = scan.nextLine();
            if(q.equals("exit")) break;
            String answer = chatClient.prompt().user(q).call().content();
            System.out.println("AI >> " + answer);
        }
    }
}
