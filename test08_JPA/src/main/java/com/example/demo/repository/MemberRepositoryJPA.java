package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//inertface끼리 상속할때에는 implements가 아닌 extends 사용
//Repository 어노테이션을 주지 않아도 JPA 내부에서 자동 처리
public interface MemberRepositoryJPA extends JpaRepository<Member,String> { //<Member객체, primary값의 타입>

    @Query("select m from Member m where m.id=:id") //Query어노테이션으로 JPQL 구문을 작성
    public Member select(@Param("id")String id);

    @Query("select m from Member m where m.age >= :age")
    public List<Member> findAgeMember(@Param("age")int age);

    //아이디와 비밀번호로 회원조회하는 메소드
    @Query("select m from Member m where m.id = :id and m.password = :pwd")
    public Member findMember (@Param("id")String id,
                              @Param("pwd")String pwd);

    @Query("select m from Member m where m.id in :ids")
    public List<Member> findMembers(@Param("ids") List<String> ids);
}
