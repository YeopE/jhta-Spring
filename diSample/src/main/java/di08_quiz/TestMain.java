package di08_quiz;

import members.dto.MyUsersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // myusers 테이블과 연동해서 CRUD해보기(mybatis사용)
        ApplicationContext ac = new ClassPathXmlApplicationContext("di01/mybatisApp.xml");
        MyUsersDao dao = (MyUsersDao) ac.getBean("myusersDao");
        int n = dao.insert(new MyUsersDto("qwer","1234","qwer@naver.com",null));
        System.out.println(n + "명 회원등록!");
    }
}

