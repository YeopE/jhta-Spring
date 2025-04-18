package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    REST API

    요청방식 :   GET       - 조회(SELECT)
               POST      - 등록(INSERT)
               PUT       - 수정(UPDATE)
               DELETE    - 삭제(DELETE)

     * 변하지 않는 데이터는 PathVariable로 파라미터를 보낸다.(상품번호,아이디....)
     http://localhost:8080/members/hello
     http://localhost:8080/members/rest
     * 변하는 데이터는 쿼리스트링으로 보낸다. (검색조건, 페이지....)
     http://localhost:8080/members?page=1

 */


@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/member")
    public ResponseEntity<String> join(@RequestBody MemberDTO dto) { //@RequestBody : 파라미터값을 json객체로 받는다.
        try {
            memberService.join(dto);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("fail", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> list() {
        List<MemberDTO> mlist = memberService.list();
        return new ResponseEntity<>(mlist,HttpStatus.OK);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")String id) {
        memberService.delete(id);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDTO> selectId(@PathVariable("id")String id) {
        MemberDTO dto = memberService.selectId(id);
        if(dto==null){
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/members")
    public ResponseEntity<String> update(@RequestBody MemberDTO dto) {
        try {
            System.out.println(dto);
            memberService.update(dto);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("fail", HttpStatus.EXPECTATION_FAILED);
        }
    }


}
