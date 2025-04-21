package aop07;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "aop07") //basePackages를 여러개 포함시킬 경우 {"",""}로 포함
@EnableAspectJAutoProxy
public class JavaConfig {
}
