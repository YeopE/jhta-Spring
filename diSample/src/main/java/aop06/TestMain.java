package aop06;

import members.dto.MembersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        MembersDao dao =(MembersDao) ac.getBean("dao"); //@Repository(value = "dao") 의 value값으로 getBean을 가져온다.
        Object dto =dao.insert("홍길동");
        System.out.println(dto);
    }
}
