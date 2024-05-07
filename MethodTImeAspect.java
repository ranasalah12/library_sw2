package com.example.Library.Management.ASOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//import java.util.logging.Logger;

@Aspect
@Component
public class MethodTImeAspect {
     Logger log =LoggerFactory.getLogger(MethodTImeAspect.class);



    @Pointcut(value = "execution(* com.example.Library.Management.models.RepositoryAPI..*(..))")
    public void forRepositoryLog() {}

    @Pointcut(value = "execution(* com.example.Library.Management.Service..*(..))")
    public void forServiceLog () {}

    @Pointcut(value = "execution(* com.example.Library.Management.Controller..*(..))")
    public void forControllerLog () {}

    @Pointcut(value = "forRepositoryLog() || forServiceLog() || forControllerLog()")
    public void forAllApp() {}

	@Before(value = "forAllApp()")
	public void beforMethod(JoinPoint joinPoint) {

		String methodName = joinPoint.getSignature().toShortString();

		log.info("====>  Method Name is >> {}" , methodName );

		Object [] args = joinPoint.getArgs();

		for (Object arg : args) {

			log.info("===> argument >> {}" , arg);
		}

	}

}
