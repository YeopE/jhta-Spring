package di07_mybatis;

import members.dto.MembersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("di01/mybatisApp.xml");
        MembersDao dao=(MembersDao) ac.getBean("membersDao");
       // int n= dao.insert(new MembersDto(1,"홍길동","010","서울",null));
       // System.out.println(n +"명의 회원등록!");
        int n= dao.update(new MembersDto(1,"김아무","111","대구",null));
        System.out.println(n +"명의 회원수정!");
        //MembersDto dto= dao.select(1);
        int n1= dao.delete(1);
        System.out.println(n1);
    }
}
