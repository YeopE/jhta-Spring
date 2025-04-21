package aop06;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "aop06")
@EnableAspectJAutoProxy //xml에 <aop:aspectj-autoproxy/>를 등록하는 어노테이션
public class JavaConfig {

}
