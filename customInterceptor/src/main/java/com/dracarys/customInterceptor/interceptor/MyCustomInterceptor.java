package com.dracarys.customInterceptor.interceptor;


import com.dracarys.customInterceptor.annotations.MyCustomAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class MyCustomInterceptor {

    @Around("@annotation(com.dracarys.customInterceptor.annotations.MyCustomAnnotation)")
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("Before the method call");

            Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
            if(method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println("annotation: " + annotation.name());
            }

            joinPoint.proceed();
            System.out.println("After the method call");
    }


}
