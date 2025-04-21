package di05_anno;

import org.springframework.stereotype.Repository;

@Repository //Repository 라는 어노테이션을 생성하면 dao 객체를 자동으로 생성해서 Bean을 생성하지 않아도 된다.
public class OracleDao implements CommonDao {
    @Override
    public void insert(String data) {
        System.out.println("오라클과 연동해서 " + data + " 추가");
    }
    @Override
    public void update(String data) {
        System.out.println("오라클과 연동해서 " + data + " 수정");
    }
    @Override
    public void delete(String data) {
        System.out.println("오라클과 연동해서 " + data + " 삭제");
    }
    @Override
    public void select(String data) {
        System.out.println("오라클과 연동해서 " + data + " 조회");
    }
}
