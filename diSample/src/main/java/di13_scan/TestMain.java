package di13_scan;

import members.dto.MembersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // component scan을 사용해서 스프링빈 을 생성하고 JdbcController를 사용해 보세요.
        ApplicationContext ac = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcController controller = (JdbcController) ac.getBean("jdbcController"); //JdbcControoler 에서 별도의 value값으로 이름을 지정하지 않으면 명칭은 class파일이름의 첫문자 소문자 형태로 자동 지정이 된다. 이름을 지정하고 싶으면 @Controller 어노테이션 바로 뒤에 ("원하는이름") 을 지정한다.
        controller.setService();
    }
}
