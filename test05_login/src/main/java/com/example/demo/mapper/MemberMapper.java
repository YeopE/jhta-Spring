package com.example.demo.mapper;

import com.example.demo.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {
    int insert(MemberDTO dto);
    MemberDTO selectId(String id);
    MemberDTO isMember(HashMap<String,String> map);
}
