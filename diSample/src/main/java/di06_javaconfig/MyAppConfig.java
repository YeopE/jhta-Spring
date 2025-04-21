package di06_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 빈 설정 클래스
public class MyAppConfig {

    @Bean //스프링 빈으로 등록해라
    public Person person() { //@Bean 어노테이션 뒤에 (name:"이름")으로 지정할수도 있지만 지정하지 않아도 메소드 이름이 Bean의 이름이 된다.
        Person p = new Person("홍길동", 20);
        return p;
    }

    @Bean(name="dao")
    public MembersDao membersDao() {
        return new MembersDao();
    }

    @Bean
    public MembersController controller() {
        MembersController c = new MembersController(membersDao()); //컨트롤러에서 MembersDao를 생성자로 호출하는데 위의 membersDao()가 MembersDao를 리턴하고 있으므로 membersDao()를 넣어주면 된다.
        return c;
    }
}
