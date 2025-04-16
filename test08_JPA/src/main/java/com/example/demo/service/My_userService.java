package com.example.demo.service;

import com.example.demo.dto.MyUserDTO;
import com.example.demo.entity.MyUser;
import com.example.demo.repository.My_userRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class My_userService {
    @Autowired
    private My_userRepository mr;

    public MyUserDTO insert(MyUserDTO dto) {
        MyUser mu = dto.toEntity();
        MyUser myUser = mr.save(mu);
        MyUserDTO myUserDTO = new MyUserDTO(myUser);
        return myUserDTO;
    }

    public List<MyUserDTO> list() {
        List<MyUser> ulist = mr.findAll();
        List<MyUserDTO> dtoList = ulist.stream().map(m->{
            return new MyUserDTO(m);
        }).toList();
        return dtoList;
    }

    public MyUserDTO select(int num) {
        Optional<MyUser> mu = mr.findById(num);
        if(!mu.isEmpty()) {
            return new MyUserDTO(mu.get());
        }else {
            return null;
        }
    }

    public MyUserDTO update(MyUserDTO dto) {
        Optional<MyUser> mu1 = mr.findById(dto.getNum());
        if(!mu1.isEmpty()) {
            MyUser mu2 = mu1.get();
            mu2.setPhone(dto.getPhone());
            mu2.setAddr(dto.getAddr());
            mr.save(mu2);
            return new MyUserDTO(mu2);
        }
        return null;
    }

    public void delete(int num) {
        mr.deleteById(num);
    }
}
