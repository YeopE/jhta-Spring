package aop03;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeAdvice {
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        //메소드 호출전에 수행
        long startTime = System.currentTimeMillis();
        
        //타겟객체 메소드 호출(핵심기능)
        Object returnValue = joinPoint.proceed(); // joinPoint.proceed();을 기준으로 실행전 실행 후로 나뉜다.
        
        //메소드 호출후에 수행
        long endTime = System.currentTimeMillis();
        double duration = (endTime - startTime)/1000.0;
//        System.out.println("메소드수행시간:" + duration + "초");
        System.out.printf("메소드수행시간: %.3f초%n", duration);
        return returnValue;
    }
}
