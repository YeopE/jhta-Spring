package transaction;

import members.dto.MembersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.MembersService;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        MembersService service =(MembersService) ac.getBean("membersService");
        service.insert(new MembersDto(3,"삼길동","010-3333-3333","부산",null));
    }
}
