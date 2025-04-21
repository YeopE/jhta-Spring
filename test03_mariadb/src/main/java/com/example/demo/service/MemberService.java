package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public int insert(MemberDTO dto) {
        return memberMapper.insert(dto);
    }
    public List<MemberDTO> selectAll() {
        return memberMapper.selectAll();
    }
    public int delete(String id) {
        return memberMapper.delete(id);
    }
    public MemberDTO selectId(String id) {
        return memberMapper.selectId(id);
    }
    public int update(MemberDTO dto) {
        return memberMapper.update(dto);
    }
    public int count() {
        return memberMapper.count();
    }
    public List<MemberDTO> list(HashMap<String, Object> map) {
        return memberMapper.list(map);
    }
    public MemberDTO isMember(HashMap<String,String> map) {
        return memberMapper.isMember(map);
    }
}
