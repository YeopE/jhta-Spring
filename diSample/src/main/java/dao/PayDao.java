package dao;

import dto.PayDto;

import java.util.List;

public interface PayDao {
    int insert(PayDto dto);
    int update(PayDto dto);
    int delete(int num);
    int selectPaynum(int num);
    List<PayDto> selectAll();
}
