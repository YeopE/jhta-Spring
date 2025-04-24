package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Member1DTO;
import com.example.test18_miniproject.entity.Member1;
import com.example.test18_miniproject.repository.Member1Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class Member1Service {
    private final Member1Repository member1Repository;
    private final PasswordEncoder passwordEncoder;


    public Member1DTO memberJoin(Member1DTO dto){

        String encodePwd = passwordEncoder.encode(dto.getPwd());
        dto.setPwd(encodePwd);

        Member1 mem1 = dto.toEntity();
        Member1 member = member1Repository.save(mem1);
        Member1DTO member1DTO = new Member1DTO(member);
        return member1DTO;
    }

    public Member1DTO findById(String id) {
        Member1 member1 = member1Repository.findById(id);
        Member1DTO member1DTO = new Member1DTO(member1);
        return member1DTO;
    }

    public boolean isMember(String id, String password){
        String encodedPwd = member1Repository.findById(id).getPwd();
        if(passwordEncoder.matches(password,encodedPwd)){
            return true;
        }else {
            return false;
        }
    }
}
