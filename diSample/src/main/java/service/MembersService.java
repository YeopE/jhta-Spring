package service;

import dao.MembersDao;
import dao.PointDao;
import dto.PointDto;
import members.dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//@Transactional //트랜잭션 처리 어노테이션 //클래스 자체에 트랜잭션을 모두 걸어줄 수 있다.
public class MembersService {
    @Autowired
    private MembersDao membersDao;
    @Autowired //자동주입 Autowired를 별도로 따로 써줘야한다.
    private PointDao pointDao;
    @Transactional //트랜잭션 처리 어노테이션 //메소드에 개별로 줘도 되고
    //회원가입
    public void insert(MembersDto dto){
        // 회원테이블에 추가
        membersDao.insert(dto);
        // 포인트 테이블에 추가
        pointDao.insert(new PointDto(0,dto.getNum(),1000));
    }
    //delete, update, select 는 구현x (들어가게 된다면 예로)
    public void delete(int num){
        pointDao.delete(num);
        membersDao.delete(num);
    }
    public void update(){}
    public void select(){}
}
