package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DAOLogAdvice {
    private final Logger logger;

    @Autowired
    public DAOLogAdvice(Logger logger) {
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.dao..*(..))")
    public void logDAOCall(JoinPoint joinpoint) {
        System.out.println("method= " + joinpoint.getSignature().getName());
    }
}
