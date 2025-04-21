package com.example.demo.dto;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentsDTO {
    private Long cnum;
    private Long mnum;
    private String id;
    private String comments;

    public CommentsDTO(Comments comm) {
        this.cnum = comm.getCnum();
        this.mnum = comm.getMovie().getMnum();
        this.id = comm.getId();
        this.comments = comm.getComments();
    }
    public Comments toEntity(Movie movie) {
        Comments comm = Comments.builder()
                .cnum(cnum)
                .movie(movie)
                .id(id)
                .comments(comments)
                .build();

        return comm;
    }
}
