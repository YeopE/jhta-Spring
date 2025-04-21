package di11_quiz;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcConfig {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("c##scott");
        ds.setPassword("tiger");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jTemplate = new JdbcTemplate();
        jTemplate.setDataSource(dataSource());
        return jTemplate;
    }

    @Bean
    public JdbcDao jdbcDao(){
        JdbcDao dao = new JdbcDao();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
