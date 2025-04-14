package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public int insert(MemberDTO dto) {
        return memberMapper.insert(dto);
    }

    public MemberDTO selectId(String id) {
        return memberMapper.selectId(id);
    }

    public MemberDTO isMember(HashMap<String,String> map) {
        return memberMapper.isMember(map);
    }
}
