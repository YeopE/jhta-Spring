package com.example.demo.repository;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b from Board b join b.member m")
    List<Board> list1();

    @Query("select b from Board b join b.member m where m.id = :id")
    List<Board> list2(@Param("id")String id);

    @Query("select new com.example.demo.dto.BoardDTO(b.num,m.email,b.title,b.content)" +
           "from Board b join b.member m")
    List<BoardDTO> list3();
}
