package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.PageResultDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor // 생성자로 주입받기
public class BoardService {
//    @Autowired
//    private BoardRepository br;
    private final BoardRepository br; //RequiredArgsConstructor어노테이션을 이용하여 final을 주면 자동 주입
//    @Autowired
//    private MemberRepository mr;
    private final MemberRepository mr;

    public BoardDTO insert(BoardDTO dto) {
        Optional<Member> m = mr.findById(dto.getId());

        if(!m.isEmpty()) {
            Member member = m.get();
            Board b = dto.toEntity(member);
            Board board = br.save(b);
            BoardDTO boardDTO = new BoardDTO(board);
            return boardDTO;
        }

        return null;
    }

    //    public BoardDTO insert2(BoardDTO dto) {
//        Optional<Member> m = mr.findById(dto.getId());
//
//        if(m.isPresent()) { //데이터가 존재하는 경우
//            Board board = dto.toEntity(m.get());
//            Board b = br.save(board);
//            return new BoardDTO(b);
//        }
//        return null;
//    }

    public PageResultDTO list (Pageable pageable) {
        Page<Board> page = br.findAll(pageable);
        List<BoardDTO> list = page.stream().map(b->new BoardDTO(b)).toList();
        PageResultDTO dto = new PageResultDTO(list, page.getNumber(), page.getTotalPages(), 3);
        return dto;
    }

    public void delete(Long num) {
        br.deleteById(num);
    }

    public BoardDTO select(Long num) {
        Optional<Board> b = br.findById(num);
        if(b.isPresent()) {
            return new BoardDTO(b.get());
        }else {
            return null;
        }
    }

    public BoardDTO update(BoardDTO dto) {
        Optional<Board> b = br.findById(dto.getNum());

        if(b.isPresent()) {
            Board board = b.get();
            board.setTitle(dto.getTitle());
            board.setContent(dto.getContent());
            br.save(board);
            return new BoardDTO(board);
        }
        return null;
    }
}
