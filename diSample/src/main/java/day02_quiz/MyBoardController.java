package day02_quiz;

import members.dto.MembersDto;
import members.dto.MyBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MyBoardController {
    @Autowired
    private MyBoardService service;

    public void service(){
        //입력
//        service.insert(new MyBoardDto(300,"유저1","제목","내용",null));
        //삭제
//        service.delete(300);
        
        //수정
//        service.update(new MyBoardDto(300,"유저변경","제목변경","내용변경",null));
        
        //조회
//        MyBoardDto dto = service.select(300);
//        if(dto != null) {
//            System.out.println("조회한 글 정보");
//            System.out.println(dto);
//        }else {
//            System.out.println("조회한 글 정보가 존재하지 않습니다.");
//        }
        
        //전체 조회
        List<MyBoardDto> list = service.selectAll();
        System.out.println("전체 글 정보");
        System.out.println(list);
    }
}
