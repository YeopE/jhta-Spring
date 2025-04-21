package di05_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("di01/di05.xml");
        BoardController controller = (BoardController)ac.getBean("controller"); //BoardController에 @Controller(value = "controller") @Controller 어노테이션에 이름을 지정하지 않으면 기본 소문자 명 boardController 으로 이름이 지정된다.
        controller.service();
    }
}
