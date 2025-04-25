package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Board1DTO;
import com.example.test18_miniproject.repository.Board1Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class Board1Service {
    private final Board1Repository board1Repository;

    public Board1DTO insert(Board1DTO dto) {
        Board1DTO insertDTO = new Board1DTO(board1Repository.save(dto.toEntity()));
        return insertDTO;
    }
}
