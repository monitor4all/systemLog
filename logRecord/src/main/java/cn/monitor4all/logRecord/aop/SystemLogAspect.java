package cn.monitor4all.logRecord.aop;

import cn.monitor4all.logRecord.bean.LogDTO;
import cn.monitor4all.logRecord.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SystemLogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(cn.monitor4all.logRecord.annotation.OperationLog)")
    public void pointcut() {
    }

    @Before("@annotation(cn.monitor4all.logRecord.annotation.OperationLog)")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("operationLogAspect");
        log.info("operationLogAspect doBefore");
        logService.createLog(new LogDTO());
    }

    @After("@annotation(cn.monitor4all.logRecord.annotation.OperationLog)")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("operationLogAspect");
        log.info("operationLogAspect doAfter");
    }

    @AfterThrowing(pointcut = "@annotation(cn.monitor4all.logRecord.annotation.OperationLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("operationLogAspect");
        log.info("operationLogAspect doAfterThrowing");
    }
}
