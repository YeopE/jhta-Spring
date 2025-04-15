package com.example.demo.mapper;

import com.example.demo.dto.MembersDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MembersMapper {
    MembersDTO isMember(HashMap<String,String> map);
}
