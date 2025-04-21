package dao;

import dto.BuyDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuyDaoImpl implements BuyDao {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE="mapper.BuyMapper";

    @Override
    public int insert(BuyDto dto){
        int n = sqlSession.insert(NAMESPACE + ".insert", dto);
        return n;
    }
    @Override
    public int update(BuyDto dto){
        int n = sqlSession.update(NAMESPACE + ".update", dto);
        return n;
    }
    @Override
    public int delete(int num) {
        int n = sqlSession.delete(NAMESPACE + ".delete", num);
        return n;
    }
    @Override
    public List<BuyDto> selectAll() {
        List<BuyDto> list = sqlSession.selectList(NAMESPACE + ".selectAll");
        return list;
    }
}
