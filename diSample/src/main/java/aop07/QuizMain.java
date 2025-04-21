package aop07;

import aop07.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizMain {
    public static void main(String[] args) {
        // 메소드의 수행시간을 출력하는기능을 aop를 이용해서 구현해 보세요. -> 어노테이션 방식으로 설정하기
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        MembersDao dao=(MembersDao)ac.getBean("dao");
        Object insert = dao.insert("홍길동1");
        Object update = dao.update("홍길동2");
        Object delete = dao.delete("홍길동3");
        Object select = dao.select("홍길동4");
    }
}
