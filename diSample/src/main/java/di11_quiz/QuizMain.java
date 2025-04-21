package di11_quiz;

import members.dto.MyUsersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
    Spring JDBC사용해서 MyUesrs테이블과 연동해서 CRUD기능 구현하기
 */
public class QuizMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcDao dao = (JdbcDao)ac.getBean("jdbcDao");

        //등록
//        int n = dao.insert(new MyUsersDto("qqq","1234","qqq@naver.com",null));
//        System.out.println(n + "명 회원등록");

        //삭제
//        int n = dao.delete("qqq");
//        System.out.println(n + "명 회원삭제");

        //수정
//          int n = dao.update(new MyUsersDto("test","4321","test@naver.com",null));
//          System.out.println(n + "명 회원수정");

        //조회
        MyUsersDto dto = dao.select("hello");
        if(dto!=null) {
            System.out.println("조회된 회원");
            System.out.println(dto);
        }else {
            System.out.println("조회된 회원이 없습니다.");
        }

        //전체 조회
        System.out.println("전체회원정보");
        dao.selectAll().forEach(m->{
            System.out.println(m);
        });
    }
}
