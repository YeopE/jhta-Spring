package day03_quiz;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {
    @Pointcut("execution(public * dao..*(..))")
    public void logTarget() {}

    @Around("logTarget()") //Around로 위의 logTarget 메소드를 포함시킨다.
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        System.out.println("메소드에 전달된 파라미터값들...");
        for(int i=0; i<args.length; i++) {
            System.out.println(i + ":" + args[i]);
        }
        Object returnValue = joinPoint.proceed(); //핵심기능을 찾는 메소드 호출
        System.out.println("메소드실행후에 리턴된 값:" + returnValue);
        return returnValue;
    }
}
