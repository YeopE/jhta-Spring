package com.example.demo.controller;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.dto.PageResultDTO;
import com.example.demo.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentsController {
    private final CommentsService commentsService;

    @PostMapping("/comments")
    public ResponseEntity<String> insert(@RequestBody CommentsDTO dto) {
        try {
            commentsService.save(dto);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("fail", HttpStatus.EXPECTATION_FAILED);
        }
    }
    //페이지 번호에 해당하는 댓글 3개 AJAX로 응답하기(PageResultDTO)하기
    @GetMapping("/comments")
    public ResponseEntity<PageResultDTO> list(@RequestParam("mnum")long mnum,
                                              @RequestParam(value = "page", defaultValue = "0")int page){
        PageRequest pageRequest = PageRequest.of(page,3);
        PageResultDTO pageResultDTO = commentsService.list(mnum,pageRequest);
        return new ResponseEntity<>(pageResultDTO,HttpStatus.OK);
    }
    @DeleteMapping("/comments/{cnum}")
    public ResponseEntity<String> delete(@PathVariable("cnum")Long cnum){
        commentsService.delete(cnum);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/comments/{cnum}")
    public ResponseEntity<CommentsDTO> selectCnum(@PathVariable("cnum")Long cnum) {
        CommentsDTO dto = commentsService.selectCnum(cnum);
        if(dto==null) {
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PutMapping("/comments")
    public ResponseEntity<String> Update(@RequestBody CommentsDTO dto) {
        try{
            System.out.println(dto);
            commentsService.update(dto);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("fail",HttpStatus.EXPECTATION_FAILED);
        }
    }
}
