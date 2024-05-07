package com.example.Library.Management.ASOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;



@Aspect
@Order(1)
@Component
public class MEAp {

    Logger log = LoggerFactory.getLogger(MethodTImeAspect.class);

    //this work in the end of and start the code

    @Around(value = "execution(* com.example.Library.Management.Service..*())")
    public Object logTime(ProceedingJoinPoint joinPoint) throws  Throwable{

        long startTime =System.currentTimeMillis();
        StringBuilder sb =new StringBuilder("KPI :");
        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
                .append("\twithArgs: ").append("(").append(StringUtils.join(joinPoint.getArgs(), ",")).append(")");
        sb.append("\ttook");
        Object returnValue =joinPoint.proceed();
        log.info(sb.append(System.currentTimeMillis() - startTime).append("ms.").toString());
        return returnValue;
    }
}
