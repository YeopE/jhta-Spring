package di09_mybatis;

import di07_mybatis.MembersDao;
import members.dto.MembersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyBatisConfig.class);
        MembersDao dao = (MembersDao) ac.getBean("membersDao");
        int n= dao.insert(new MembersDto(100,"아리랑","010","서울",null));
        System.out.println(n + "명 회원 등록!");
    }
}
