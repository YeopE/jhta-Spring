package di12_scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyBatisConfig.class);
        MembersController controller = (MembersController) ac.getBean("membersController");
        controller.service();
        MyPage mp = (MyPage) ac.getBean("myPage");
        mp.printInfo("테스트.....");
    }
}
