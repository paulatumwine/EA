package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {
    private final Logger logger;

    @Autowired
    public JMSLogAdvice(Logger logger) {
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(..))")
    public void logJMSMessage(JoinPoint joinpoint) {
        System.out.println("message= " + joinpoint.getArgs()[0]);
    }
}
