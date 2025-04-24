package com.example.test18_miniproject.repository;

import com.example.test18_miniproject.entity.Member1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Member1Repository extends JpaRepository<Member1, Long> {
    Member1 findById(String id);
}
