package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.library.service.BookService.*(..))")
    public void bookServiceMethods() {}

    @Before("bookServiceMethods()")
    public void beforeMethod() {
        System.out.println("Entering method: BookService method");
    }

    @After("bookServiceMethods()")
    public void afterMethod() {
        System.out.println("Exiting method: BookService method");
    }
}
