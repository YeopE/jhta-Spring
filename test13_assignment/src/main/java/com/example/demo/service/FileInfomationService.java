package com.example.demo.service;

import com.example.demo.dto.FileInfomationDTO;
import com.example.demo.entity.FileInfomation;
import com.example.demo.repository.FileInfomationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class FileInfomationService {
    private final FileInfomationRepository fileInfoRepository;

    public FileInfomationDTO insert(FileInfomationDTO dto) {
        FileInfomation fileInfomation = dto.toEntity();
        FileInfomation f = fileInfoRepository.save(fileInfomation);
        FileInfomationDTO fileInfoDTO = new FileInfomationDTO(f);
        return fileInfoDTO;
    }
}
