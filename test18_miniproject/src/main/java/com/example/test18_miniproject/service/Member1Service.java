package com.example.test18_miniproject.service;

import com.example.test18_miniproject.dto.Member1DTO;
import com.example.test18_miniproject.dto.PageResultDTO;
import com.example.test18_miniproject.entity.Member1;
import com.example.test18_miniproject.repository.Member1Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public Member1DTO memberUpdate(Member1DTO dto) {
        String encodePwd = passwordEncoder.encode(dto.getPwd());
        dto.setPwd(encodePwd);

        Member1 m = dto.toEntity();
        Member1 m1= member1Repository.findById(m.getId());

        if(m1 != null) {
            m1.setPwd(m.getPwd());
            m1.setPhone(m.getPhone());
            m1.setEmail(m.getEmail());
            m1.setAddr(m.getAddr());

            member1Repository.save(m1);
            return new Member1DTO(m1);
        }
        return null;
    }

    public PageResultDTO pageList (Pageable pageable) {
        Page<Member1> page = member1Repository.findAll(pageable);
        List<Member1DTO> list = page.stream().map(m->new Member1DTO(m)).toList();
        PageResultDTO dto = new PageResultDTO(list, page.getNumber(), page.getTotalPages(),5);
        return dto;
    }

    public void memberDelete(Long id) {
        member1Repository.deleteById(id);
    }


}
