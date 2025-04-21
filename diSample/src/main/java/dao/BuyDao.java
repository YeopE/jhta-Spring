package dao;

import dto.BuyDto;

import java.util.List;

public interface BuyDao {
    int insert(BuyDto dto);
    int update(BuyDto dto);
    int delete(int num);
    List<BuyDto> selectAll();
}
