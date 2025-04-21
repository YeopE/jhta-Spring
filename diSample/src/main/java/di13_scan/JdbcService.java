package di13_scan;


import members.dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JdbcService {
    @Autowired
    private JdbcDao dao;

    public void insert(MembersDto dto){
        dao.insert(dto);
    }
    public void update(MembersDto dto){
        dao.update(dto);
    }
    public void delete(int num){
        dao.delete(num);
    }
    public MembersDto select(int num){
        return dao.select(num);
    }
}
