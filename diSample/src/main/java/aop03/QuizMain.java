package aop03;

import aop01.MembersDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizMain {
    public static void main(String[] args) {
        // 메소드의 수행시간을 출력하는 기능을 aop를 이용해서 구현해 보세요.
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop/aop03.xml");
        MembersDao dao = (MembersDao)ac.getBean("membersDao");
        dao.insert("홍길동1");
        dao.update("홍길동2");
        dao.delete("홍길동3");
        dao.select("홍길동4");
    }
}
