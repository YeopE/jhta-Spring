package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    //findByNameOrTel (검색한 name과 tel중에 DB에 있는 것 조회)
    List<Student> findByNameOrTel(String name, String tel);

    //findByNameContaining (검색한 이름이 포함된 DB 목록 조회)
    List<Student> findByNameContaining(String name);
}
