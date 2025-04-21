package aop04;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

//MethodBeforeAdvice 인터페이스를 상속받으면 메소드실행전에 동작되는 어드바이스가 됨 (조인포인트 지점이 이미 지정된다는 것과 같음 그래서 aop에서 advisor를 사용)
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws  Throwable{
        System.out.println("호출되는 메소드 ==>" + method.getName());
        System.out.println("전달되는 파라미터들...");
        for(Object p:args){
            System.out.println(p);
        }
        System.out.println();
        System.out.println("target ==>" + target);
    }
}
