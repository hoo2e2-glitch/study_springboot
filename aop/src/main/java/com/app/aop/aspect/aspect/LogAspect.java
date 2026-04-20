package com.app.aop.aspect.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
// 관점을 지향
@Aspect
@Slf4j
public class LogAspect {

//    @Before("@annotation(com.app.aop.aspect.annotation.LogStatus)")
//    // JoinPoint : 나중의 실행되는
//    public void beforeStart(JoinPoint joinPoint) {
//        log.info("joinPoint : " + joinPoint); // 조인포인트 객체
//        log.info("join point args : " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "))); // 파라미터
//        log.info("joinPoint : " + joinPoint.getSignature().getName()); // 메서드 이름
//        log.info("joinPoint : " + joinPoint.getTarget()); // 타켓
//
//    }
    // @After : 메인 메서드실행직전에
//    @After("@annotation(com.app.aop.aspect.annotation.LogStatus)")
//    // JoinPoint : 나중의 실행되는
//    public void beforeStart(JoinPoint joinPoint) {
//        log.info("joinPoint : " + joinPoint); // 조인포인트 객체
//        log.info("join point args : " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "))); // 파라미터
//        log.info("joinPoint : " + joinPoint.getSignature().getName()); // 메서드 이름
//        log.info("joinPoint : " + joinPoint.getTarget()); // 타켓
//
//    }

//    // @AfterReturning : return이 된 이후에 실행되는 시점// 함수가 return 되기 직전에 먼저 실행됨 // After보다 먼저 실행
//    @AfterReturning(value = "@annotation(com.app.aop.aspect.annotation.LogStatus)", returning = "returnValue")
//    // JoinPoint : 나중의 실행되는
//    public void afterReturning(JoinPoint joinPoint, Integer returnValue) {
//        log.info("joinPoint : " + joinPoint); // 조인포인트 객체
//        log.info("join point args : " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "))); // 파라미터
//        log.info("joinPoint : " + joinPoint.getSignature().getName()); // 메서드 이름
//        log.info("joinPoint : " + joinPoint.getTarget()); // 타켓
//        log.info("joinPoint : " + returnValue); // callback 함수처럼 사용
//
//    }

    // @AfterThrowing : 예외를 잡아서 처리 x
    // -> 예외가 발생하고 나면 어떻게 처리할것인가
//    @AfterThrowing(value = "@annotation(com.app.aop.aspect.annotation.LogStatus)", throwing = "")
//    // JoinPoint : 나중의 실행되는
//    public void afterThrowing(JoinPoint joinPoint, Exception e) {
//        log.info(e.getMessage());
//    }

    //  @Around : 메인관점을 다시 재정의 / 오버라이딩
    @Around(value = "@annotation(com.app.aop.aspect.annotation.LogStatus)")
    // JoinPoint : 나중의 실행되는
    public Integer around(ProceedingJoinPoint proceedingJoinPoint) {

        log.info("point cut", proceedingJoinPoint);
        Integer result = 0;

        try {
        result = (Integer) proceedingJoinPoint.proceed();
        }catch (NumberFormatException e){
            log.info("NumberFormatException");
        }catch (Throwable e){
            throw  new RuntimeException(e);
        }

        return result;
    }

}
