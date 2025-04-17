package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    //limit : 몇개 추출, offset : 몇페이지부터
    @Query("select m from Member m order by m.id limit :b offset :a")
    List<Member> list1(@Param("a")int a, @Param("b")int b); // a=0, b=10 -> 1페이지에서 10개 추출

    // nativeQuery = true (실제 nativeQuery와 동일하게 사용하겠다.)
    @Query(value = "select * from member order by id limit :a, :b", nativeQuery = true) //dbModel이 바뀔 수 있어 권장하지 않음
    List<Member> list2(@Param("a")int a, @Param("b")int b);

    public Page<Member> findAll(Pageable pageable); //페이징 처리시 JpaRepository를 상속받기 때문에 findAll이름을 바꾸면 안된다.

    @Modifying //DML 작업할때는 반드시 어노테이션 설정해야 함
    @Query("update Member m set m.age=m.age+10 where m.id=:id")
    public int update(@Param("id")String id);
}
