package Utile;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.demo.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("Method {} called with args {}", joinPoint.getSignature(), joinPoint.getArgs());
        Object result = joinPoint.proceed();
        logger.info("Method {} returned {} in {}ms", joinPoint.getSignature(), result, System.currentTimeMillis() - start);
        return result;
    }
}
