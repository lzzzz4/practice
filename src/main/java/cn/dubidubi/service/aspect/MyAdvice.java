package cn.dubidubi.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Before("execution(* cn.dubidubi.service..*.hell*(..))")
    public void lzj(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        for (Object object : args) {
            System.out.println(object);
        }
        System.out.println("lzj111");
    }
}
