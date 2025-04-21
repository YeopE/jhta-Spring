package di13_scan;

import members.dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class JdbcController {
    @Autowired
    private JdbcService service;
    public void setService(){
        MembersDto dto = service.select(2);
        System.out.println(dto);
    }
}
