package com.example.demo.mapper;

import com.example.demo.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper //xml과 interface 간의 연결 구현체를 생성
public interface MemberMapper {
    int insert(MemberDTO dto);
    List<MemberDTO> selectAll();
    int delete(String id);
    MemberDTO selectId(String id);
    int update(MemberDTO dto);
    int count();
    List<MemberDTO> list(HashMap<String, Object> map);
    MemberDTO isMember(HashMap<String, String> map);
}

