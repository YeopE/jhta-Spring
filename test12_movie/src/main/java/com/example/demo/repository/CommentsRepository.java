package com.example.demo.repository;

import com.example.demo.entity.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    //영화번호에 해당하는 전체 댓글 목록 얻어오기
    @Query("select c from Comments c join c.movie m where m.mnum=:mnum") //JPQL
    List<Comments> findByMnum(@Param("mnum")Long mnum);

    //현재 페이지에 댓글목록 얻어오기
    @Query("select c from Comments c join c.movie m where m.mnum=:mnum")
    Page<Comments> findByMnum(@Param("mnum")Long mnum,
                              PageRequest pageRequest);
}
