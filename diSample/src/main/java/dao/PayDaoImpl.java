package dao;

import dto.PayDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PayDaoImpl implements PayDao {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE="mapper.PayMapper";

    @Override
    public int insert(PayDto dto) {
        int n = sqlSession.insert(NAMESPACE + ".insert", dto);
        return n;
    }

    @Override
    public int update(PayDto dto) {
        int n = sqlSession.update(NAMESPACE + ".update", dto);
        return n;
    }

    @Override
    public int delete(int num) {
        int n = sqlSession.delete(NAMESPACE + ".delete", num);
        return n;
    }

    @Override
    public int selectPaynum(int num){
        int n = sqlSession.selectOne(NAMESPACE + ".selectPaynum", num);
        return n;
    }


    public List<PayDto> selectAll(){
        List<PayDto> list = sqlSession.selectList(NAMESPACE + ".selectAll");
        return list;
    }
}
