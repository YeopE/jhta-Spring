package com.example.demo.service;

import com.example.demo.dto.FileinfoDTO;
import com.example.demo.entity.Fileinfo;
import com.example.demo.repository.FileinfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FileinfoService {
    @Autowired
    private FileinfoRepository fileinfoRepository;

    public FileinfoDTO insert(FileinfoDTO dto){
        return new FileinfoDTO(fileinfoRepository.save(dto.toEntity()));
    }
    public List<FileinfoDTO> list() {
        return fileinfoRepository.findAll().stream().map(f->new FileinfoDTO(f)).toList();
    }
    public FileinfoDTO select(long filenum) {
        return new FileinfoDTO(fileinfoRepository.findById(filenum).get());
    }
    public void delete(long filenum) {
        fileinfoRepository.deleteById(filenum);
    }
    public FileinfoDTO update(FileinfoDTO dto) {
        Fileinfo file = fileinfoRepository.findById(dto.getFilenum()).get();
        file.setContent(dto.getContent());
        file.setFilesize(dto.getFilesize());
        file.setOrgfilename(dto.getOrgfilename());
        file.setSavefilename(dto.getSavefilename());
        file.setTitle(dto.getTitle());
        file.setWriter(dto.getWriter());
        return new FileinfoDTO(file);
    }
}
