package di06_javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);
        Person pp = (Person)ac.getBean("person");
        System.out.println(pp.getName() + "," + pp.getAge());

        //dao로 설정하고 객체 얻어와서 사용해 보세요.
        MembersDao dao = (MembersDao) ac.getBean("dao");
        dao.insert("홍길동");
        dao.delete("홍길동");
        dao.update("홍길동");
        dao.select("홍길동");

        MembersController controller = (MembersController)ac.getBean("controller");
        controller.service();
    }
}
