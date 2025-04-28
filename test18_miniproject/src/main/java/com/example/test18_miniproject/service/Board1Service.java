package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Board1DTO;
import com.example.test18_miniproject.dto.PageResultDTO;
import com.example.test18_miniproject.entity.Board1;
import com.example.test18_miniproject.repository.Board1Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class Board1Service {
    @Value("${file.path}")
    private String filepath;

    private final Board1Repository board1Repository;

    public Board1DTO insert(Board1DTO dto) {
        Board1DTO insertDTO = new Board1DTO(board1Repository.save(dto.toEntity()));
        return insertDTO;
    }

    public PageResultDTO pageList (Pageable pageable) {
        Page<Board1> page = board1Repository.findAll(pageable);
        List<Board1DTO> list = page.stream().map(b->new Board1DTO(b)).toList();
        PageResultDTO dto = new PageResultDTO(list, page.getNumber(), page.getTotalPages(), 5);
        return dto;
    }

    public Board1DTO select(Long postNum) {
        Board1DTO board1DTO = new Board1DTO(board1Repository.findById(postNum).get());
        return board1DTO;
    }

    public void delete(Long postNum) {
        Optional<Board1> board1 = board1Repository.findById(postNum);

        deleteFile(board1.get().getFilename1());
        deleteFile(board1.get().getFilename2());
        deleteFile(board1.get().getFilename3());

        board1Repository.deleteById(postNum);
    }

    public void deleteFile(String filename) {
        if(filename != null) {
            File file = new File(filepath + File.separator + filename);
            if(file.exists()){
                boolean result = file.delete();
                if(result) {
                    System.out.println(filename + "파일 삭제 성공");
                }else {
                    System.out.println(filename + "파일 삭제 실패");
                }
            }else {
                System.out.println(filename + "파일이 존재하지 않습니다.");
            }
        }
    }

    public Board1DTO update(Board1DTO dto) {
        Board1 board1 = board1Repository.findById(dto.getPostNum()).get();
        board1.setMember1(dto.getMember1());
        board1.setTitle(dto.getTitle());
        board1.setContent(dto.getContent());
        board1.setFilename1(dto.getFilename1());
        board1.setFilename2(dto.getFilename2());
        board1.setFilename3(dto.getFilename3());
        board1.setUpdateAt(LocalDateTime.now());
        Board1DTO board1DTO = new Board1DTO(board1);
        return board1DTO;
    }
}
