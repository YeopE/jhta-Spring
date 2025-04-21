package day02_quiz;

import members.dto.MyBoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MyBoardDao {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE="mapper.MyBoardMapper";

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insert(MyBoardDto dto) {
        int n = sqlSession.insert(NAMESPACE + ".insert", dto);
        return n;
    }

    public int delete(int num) {
        int n = sqlSession.delete(NAMESPACE + ".delete", num);
        return n;
    }

    public int update(MyBoardDto dto) {
        int n = sqlSession.update(NAMESPACE + ".update", dto);
        return n;
    }

    public MyBoardDto select(int num){
        MyBoardDto dto = sqlSession.selectOne(NAMESPACE + ".select", num);
        return dto;
    }

    public List<MyBoardDto> selectAll(){
        List<MyBoardDto> list = sqlSession.selectList(NAMESPACE + ".selectAll");
        return list;
    }

}
