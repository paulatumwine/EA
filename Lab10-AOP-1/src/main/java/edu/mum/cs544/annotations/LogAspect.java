package edu.mum.cs544.annotations;

import edu.mum.cs544.EmailSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());

    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
    public void logAfter(JoinPoint joinpoint) {
        // logger.warn(new Date() + " method= " + joinpoint.getSignature().getName());
        Object[] args = joinpoint.getArgs();
        System.out.println(
                new Date()
                        + " method= " + joinpoint.getSignature().getName()
                        + " address=" + args[0]
                        + " message= " + args[1]
        );
        System.out.println(
                "outgoing mail server = " + ((EmailSender) joinpoint.getTarget()).getOutgoingMailServer()
        );
    }
}
