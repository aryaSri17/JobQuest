package org.example.JobPortalApplication.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    private static final Logger log= LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* org.example.JobPortalApplication.service.JobPortalServices.*(..))")
    public Object TotalTime(ProceedingJoinPoint pjp) throws Throwable {
        long start=System.currentTimeMillis();
        Object obj=pjp.proceed();
        long end=System.currentTimeMillis();
        log.info("Method "+pjp.getSignature().getName() + " has taken "+(end-start)+" ms");
        return obj;
    }
}
