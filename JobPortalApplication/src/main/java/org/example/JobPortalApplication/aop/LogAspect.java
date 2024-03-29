package org.example.JobPortalApplication.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    private static final Logger log= LoggerFactory.getLogger(LogAspect.class);

    //returntype class-name.method_name(args)
    @Before("execution(* org.example.JobPortalApplication.service.JobPortalServices.*(..))")
    public void methodCalled(JoinPoint jp){
        log.info("Method Called : "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* org.example.JobPortalApplication.service.JobPortalServices.getJobs(..))")
    public void methodEncounteredError(){
        log.info("Method has some issues...");
    }

    @AfterReturning("execution(* org.example.JobPortalApplication.service.JobPortalServices.getJobs(..))")
    public void methodExecuted(){
        log.info("Method executed successfully!!");
    }

    @After("execution(* org.example.JobPortalApplication.service.JobPortalServices.getJobs(..))")
    public void methodFinished(){
        log.info("Method has completed.");
    }
}
