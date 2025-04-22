package com.example.demo.repository;

import com.example.demo.entity.FileInfomation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfomationRepository extends JpaRepository<FileInfomation, Long> {
}
