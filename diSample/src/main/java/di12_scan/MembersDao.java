package di12_scan;

import members.dto.MembersDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //이 클래스가 데이터베이스(DB) 작업을 담당하는 DAO(Repository) 클래스임을 스프링에게 알려주는 역할이야.
            // 스프링이 이 클래스를 빈(bean) 으로 등록해서 자동으로 관리할 수 있게 해줘.

public class MembersDao {
    @Autowired //SqlSession 객체를 스프링이 자동으로 주입(injection) 해주는 역할
    private SqlSession sqlSession;
    private final String NAMESPACE="mapper.MembersMapper";

    //스프링이 생성해준 객체를 주입받아야 하므로 setter내지는 생성자가 필요하다.
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insert(MembersDto dto){
      int n=  sqlSession.insert(NAMESPACE +".insert",dto);
      return n;
    }
    public int delete(int num){
        int n=  sqlSession.delete(NAMESPACE +".delete",num);
        return n;
    }
    public int update(MembersDto dto){
        int n=  sqlSession.update(NAMESPACE +".update",dto);
        return n;
    }
    public MembersDto select(int num){
        return sqlSession.selectOne(NAMESPACE +".getinfo",num);
    }
}
