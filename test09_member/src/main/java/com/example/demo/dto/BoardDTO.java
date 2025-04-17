package com.example.demo.dto;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDTO {
    private Long num;
    private String id; //Member id
    private String title;
    private String content;
    private LocalDateTime regdate;

    public BoardDTO(Board board) {
        this.num = board.getNum();
        this.title = board.getTitle();
        this.id = board.getMember().getId();
        this.content = board.getContent();
        this.regdate = board.getRegdate();
    }

    public Board toEntity(Member member) {
        return Board.builder()
                    .num(this.num)
                    .title(this.title)
                    .member(member) //Member 객체를 전달해야 함
                    .content(this.content)
                    .regdate(this.regdate)
                    .build();
    }
}
