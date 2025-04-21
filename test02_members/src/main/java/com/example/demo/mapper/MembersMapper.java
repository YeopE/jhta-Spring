package com.example.demo.mapper;

import com.example.demo.dto.MembersDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // MyBatis가 이 인터페이스의 구현체를 자동으로 생성하도록 지정하는 어노테이션.
        // XML 또는 어노테이션 기반 매핑 정보를 바탕으로 DAO 역할을 수행하며, 별도의 구현 클래스 작성이 필요 없다.
public interface MembersMapper {
    int insert(MembersDTO dto);
    int delete(int num);
    int update(MembersDTO dto);
    MembersDTO getinfo(int num);
    List<MembersDTO> selectAll();
}
