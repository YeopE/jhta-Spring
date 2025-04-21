package di09_mybatis;

import di07_mybatis.MembersDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Bean을 사용하기 위한 Configuration 어노테이션을 등록해야 한다.
public class MyBatisConfig {
    @Autowired //자동으로 주입
    private ApplicationContext ac;

    // dataSource 설정
    @Bean //Bean 등록
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("c##scott");
        ds.setPassword("tiger");
        return ds;
    }
    // sqlSessionFactory 설정
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(ac.getResources("classpath*:mapper/*.xml"));
        SqlSessionFactory factory = (SqlSessionFactory) sqlSessionFactoryBean.getObject();
        return factory;
    }
    // sqlSession 설정
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }
    // dao 설정
    @Bean
    public MembersDao membersDao() throws Exception {
        MembersDao dao = new MembersDao();
        dao.setSqlSession(sqlSessionTemplate());
        return dao;
    }
}
