package di08_quiz;

import members.dto.MyUsersDto;
import org.apache.ibatis.session.SqlSession;

public class MyUsersDao {
    private SqlSession sqlSession;
    private final String NAMESPACE = "mapper.MyUsersMapper";

    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    public int insert(MyUsersDto dto) {
        int n = sqlSession.insert(NAMESPACE + ".insert", dto);
        return  n;
    }
    public int delete(String id) {
        int n = sqlSession.delete(NAMESPACE + ".delete", id);
        return n;
    }
    public int update(MyUsersDto dto) {
        int n = sqlSession.update(NAMESPACE + ".update", dto);
        return n;
    }
    public MyUsersDto select(String id) {
        return sqlSession.selectOne(NAMESPACE + ".getinfo", id);
    }

}
