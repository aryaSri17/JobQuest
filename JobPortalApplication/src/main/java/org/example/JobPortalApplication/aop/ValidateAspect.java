package org.example.JobPortalApplication.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateAspect {
    private static final Logger log= LoggerFactory.getLogger(ValidateAspect.class);

    @Around("execution(* org.example.JobPortalApplication.service.JobPortalServices.getJobAt(..)) && args(postID)")
    public Object handleEmptySpaces(ProceedingJoinPoint pjp,String postID) throws Throwable {
        if(postID.charAt(0)==32){
            log.info("It contains front empty space");
            postID=postID.trim();
        }
        Object obj=pjp.proceed(new Object[]{postID});
        return obj;
    }
}
