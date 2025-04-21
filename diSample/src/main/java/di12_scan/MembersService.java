package di12_scan;

import members.dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {
    @Autowired //자동 주입 어노테이션 Autowired를 빼면 nullPointException이 발생한다.
    private MembersDao dao;
    public void insert(MembersDto dto){
        dao.insert(dto);
    }
    public void delete(int num){
        dao.delete(num);
    }
    public void update(MembersDto dto){
        dao.update(dto);
    }
    public MembersDto select(int num) {
        return dao.select(num);
    }
}
