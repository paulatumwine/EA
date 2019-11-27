package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAdvice {
    private final Logger logger;

    @Autowired
    public StopWatchAdvice(Logger logger) {
        this.logger = logger;
    }

    @Around("execution(* edu.mum.cs544.bank.service..*(..))")
    public Object methodTimer(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute " + call.getSignature().getName() + " " + totalTime + " ms");
        return retVal;
    }
}
