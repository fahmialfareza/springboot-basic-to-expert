package com.fahmialfareza.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("target(com.fahmialfareza.spring.aop.service.HelloService)")
    public void helloServiceMethod() {
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before executing method: {}.{}()", className, methodName);
    }

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        try {
            log.info("Around before executing method: {}.{}()", className, methodName);
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info("Around exception in method: {}.{}()", className, methodName);
            throw throwable;
        } finally {
            log.info("After executing method: {}.{}()", className, methodName);
        }
    }

    @Pointcut("execution(* com.fahmialfareza.spring.aop.service.HelloService.*(java.lang.String))")
    public void pointcutHelloServiceStringParams() {

    }

//    @Before("pointcutHelloServiceStringParams()")
//    public void logStringParameter(JoinPoint joinPoint) {
//        String value = (String) joinPoint.getArgs()[0];
//        log.info("Execute method with string parameter: {}", value);
//    }

    @Before("pointcutHelloServiceStringParams() && args(name)")
    public void logStringParameter(String name) {
        log.info("Execute method with string parameter: {}", name);
    }

    @Pointcut("execution(* com.fahmialfareza.spring.aop.service.*.*(..))")
    public void pointcutServicePackage() {

    }

    @Pointcut("bean(*Service)")
    public void pointcutServiceMethod() {

    }

    @Pointcut("execution(public * *(..))")
    public void pointcutPublicMethod() {

    }

    @Pointcut("pointcutServicePackage() && pointcutServiceMethod() && pointcutPublicMethod()")
    public void publicMethodForService() {

    }

    @Before("publicMethodForService()")
    public void logAllPublicServiceMethod() {
        log.info("Log for all public service methods");
    }
}
