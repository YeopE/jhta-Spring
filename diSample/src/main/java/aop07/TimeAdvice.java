package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAdvice {
    @Pointcut("execution(public * aop07..*(..))")
    public void time(){}

    @Around("time()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        double duration = (endTime - startTime)/1000.0;
        System.out.printf("메소드수행시간: %.3f초%n", duration);

        return returnValue;
    }
}
