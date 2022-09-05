package aop.learn1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    //    该注解表述在 UserService 执行任何 public 方法之前先执行该方法
    @Before("execution(public * aop.learn1.service.UserService.*(..))")
    public void doAccessCheck() {
        System.err.println("[Before] do access check ...");
    }

    //    该注解表示在 MailService 执行任何 public 方法之前、之后都执行该方法
    @Around("execution(public * aop.learn1.service.MailService.* (..))")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        System.err.println("[Around start]" + pjp.getSignature());
        Object retVal = pjp.proceed();
        System.err.println("[Around done]" + pjp.getSignature());
        return retVal;
    }
}
