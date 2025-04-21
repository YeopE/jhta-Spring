package di03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("di01/di03.xml"); //resources의 xml 경로
        BoardController boardController = (BoardController) ac.getBean("boardController");
        boardController.service();

    }
}
