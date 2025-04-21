package di12_scan;

import members.dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MembersController {
    @Autowired //Autowired가 포함되지않으면 자동주입이 되지 않아 NullPointerException 에러가 난다.
    private MembersService service;

    public void service(){
//        service.insert(new MembersDto(300,"홍삼백","010-300-300","종로",null));
        MembersDto dto = service.select(300);
        System.out.println(dto);
    }
}
