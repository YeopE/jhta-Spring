package com.example.demo.service;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.dto.PageResultDTO;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final MovieRepository movieRepository;

    //저장
    public CommentsDTO save(CommentsDTO dto) {
        Movie m = movieRepository.findById(dto.getMnum()).get();
        Comments comm = dto.toEntity(m);
        Comments c = commentsRepository.save(comm);
        return new CommentsDTO(c);
    }

    //삭제하기
    public void delete(Long cnum) {
        commentsRepository.deleteById(cnum);
    }

    //전체 목록 얻어오기
    public PageResultDTO list(Long mnum, PageRequest pageable){
        Page<Comments> pagelist = commentsRepository.findByMnum(mnum, pageable);
        List<CommentsDTO> clist = pagelist.stream().map(b->new CommentsDTO(b)).toList();
        PageResultDTO pageResultDTO = new PageResultDTO(clist, pagelist.getNumber(), pagelist.getTotalPages(), 3);
        return pageResultDTO;
    }

    // 댓글 찾기
    public CommentsDTO selectCnum(Long cnum) {
        Optional<Comments> comments = commentsRepository.findById(cnum);
        if(comments.isPresent()) {
            return new CommentsDTO(comments.get());
        }
        return null;
    }

    //수정
    public CommentsDTO update(CommentsDTO dto) {
        Optional<Comments> comments = commentsRepository.findById(dto.getCnum());
        if(comments.isPresent()) {
            Comments comm = comments.get();
            comm.setId(dto.getId());
            comm.setComments(dto.getComments());
            commentsRepository.save(comm);
            return new CommentsDTO(comm);
        }
        return null;
    }
}
