package members.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor //디폴트생성자 자동 생성
@AllArgsConstructor //생성자 자동 생성
@Data //getter,setter,tostring 메소드 오버라이딩
public class MyBoardDto {
    private int num;
    private String writer;
    private String title;
    private String content;
    private Date regdate;
}
