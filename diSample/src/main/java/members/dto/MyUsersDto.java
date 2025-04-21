package members.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data //setter / getter / toString 메소드 오버라이딩
public class MyUsersDto {
    private String id;
    private String pwd;
    private String email;
    private Date regdate;
}
