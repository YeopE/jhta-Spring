package di13_scan;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"di13_scan"}) //패키지 이하의 클래스들을 순회하여 빈으로 등록될 객체들을 탐색
                                             //스캔해야할 목록이 여러개면 배열 형태로 작성해서 넣어줄 수 있다.
public class JdbcConfig {
    @Autowired //자동 주입
    private ApplicationContext ac;
    // dataSource 설정
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("c##scott");
        ds.setPassword("tiger");
        return ds;
    }

    //jdbcTemplate 설정
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jTemplate = new JdbcTemplate();
        jTemplate.setDataSource(dataSource());
        return jTemplate;
    }
}
