package com.example.test18_miniproject.dto;

import com.example.test18_miniproject.entity.Board1;
import com.example.test18_miniproject.entity.Member1;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Board1DTO {
    private Long postNum;
    private Member1 member1;
    private String title;
    private String content;
    private String filename1;
    private String filename2;
    private String filename3;
    private LocalDateTime regdate;
    private LocalDateTime updateAt;

    public Board1DTO(Board1 board1){
        this.postNum = board1.getPostNum();
        this.member1 = board1.getMember1();
        this.title = board1.getTitle();
        this.content = board1.getContent();
        this.filename1 = board1.getFilename1();
        this.filename2 = board1.getFilename2();
        this.filename3 = board1.getFilename3();
        this.regdate = board1.getRegdate();
        this.updateAt = board1.getUpdateAt();
    }

    public Board1 toEntity() {
        Board1 board1 = Board1.builder()
                .postNum(postNum)
                .member1(member1)
                .title(title)
                .content(content)
                .filename1(filename1)
                .filename2(filename2)
                .filename3(filename3)
                .regdate(regdate)
                .updateAt(updateAt)
                .build();
        return board1;
    }
}
