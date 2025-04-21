package day02_quiz;

import members.dto.MyBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyBoardService {
    @Autowired
    private MyBoardDao dao;
    public void insert(MyBoardDto dto) {
        dao.insert(dto);
    }
    public void delete(int num) {
        dao.delete(num);
    }
    public void update(MyBoardDto dto) {
        dao.update(dto);
    }
    public MyBoardDto select(int num) {
        MyBoardDto dto = dao.select(num);
        return dto;
    }
    public List<MyBoardDto> selectAll() {
        List<MyBoardDto> list = dao.selectAll();
        return list;
    }
}
