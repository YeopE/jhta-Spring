package day02_quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyBoardMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyBatisConfig.class);
        MyBoardController controller = (MyBoardController)ac.getBean("myBoardController");
        controller.service();
    }
}
