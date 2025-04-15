package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//inertface끼리 상속할때에는 implements가 아닌 extends 사용
//Repository 어노테이션을 주지 않아도 JPA 내부에서 자동 처리
public interface MemberRepositoryJPA extends JpaRepository<Member,String> { //<Member객체, primary값의 타입>
}
