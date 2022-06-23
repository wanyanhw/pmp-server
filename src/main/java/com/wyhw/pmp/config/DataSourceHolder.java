package com.wyhw.pmp.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wanyanhw
 * @date 2022/6/20 20:39
 */
@Aspect
@Component
@Order(0)
public class DataSourceHolder {
    @Pointcut("@annotation(com.wyhw.pmp.config.DataSource)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DataSource annotation = joinPoint.getSignature().getClass().getAnnotation(DataSource.class);
        if (annotation == null) {
            annotation = method.getAnnotation(DataSource.class);
        }
        DynamicDataSource.setDataSource(annotation == null ? DataSourceNames.PMP : annotation.target());
        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }
}
