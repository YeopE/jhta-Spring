package di10_springjdbc;

import members.dto.MembersDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcDao dao = (JdbcDao)ac.getBean("jdbcDao");
//        int n = dao.insert(new MembersDto(12,"이길동","333","부산",null));
//        System.out.println(n + "명 회원등록");

//        int n = dao.delete(100);
//        System.out.println(n + "명 삭제");

        //수정하기 (이름/전화번호/주소 수정)

//        int n1 = dao.update(new MembersDto(12,"십이길동","123","제주",null));
//        System.out.println(n1 + "명 회원수정");

        MembersDto dto = dao.select(20); //mybatis에서 없는 번호를 입력하면 null값이 리턴디는데 jdbc는 예외가 발생하기 때문에 null로 비교해서 안되고 예외처리를 해야한다.
        if(dto==null){
            System.out.println("조회된 회원이 없습니다.");
        }else {
            System.out.println("조회된 회원");
            System.out.println(dto);
        }

        System.out.println("<<전체 회원 정보>>");
        dao.selectAll().forEach(m->{
            System.out.println(m);
        });
    }
}
