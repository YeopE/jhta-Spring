package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface My_userRepository extends JpaRepository<MyUser, Integer> {

}
