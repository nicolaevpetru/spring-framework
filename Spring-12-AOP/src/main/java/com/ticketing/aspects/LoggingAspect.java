package com.ticketing.aspects;


import com.ticketing.controller.ProductController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

//    @Pointcut("execution(* com.ticketing.controllerProductController.*(..))")
//    public void pointcut(){}
//
//    @Before("pointcut()")
//    public void log(){
//        logger.info("-------------");
//    }
//
//
//    @Before("execution(* com.ticketing.controller.ProductController.*(..))")
//    public void beforeAdvice(){
//        logger.info("-----------");
//    }
//

    //execution
    @Pointcut("execution(* com.ticketing.controller.ProductController.up*(..))")
    private void anyUpdateOperation() {
    }

    @Pointcut("execution(* com.ticketing.repository.ProductRepository.findById(Long))")
    private void anyProductRepositoryFindById() {
    }

    @Before("anyProductRepositoryFindById()")
    public void beforeProductRepoAdvice(JoinPoint joinPoint) {
        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    @Before("anyUpdateOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint) {
        logger.info("Before -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //within
    @Pointcut("within(com.ticketing.controller..*)")
    private void anyControllerOperation() {
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation() {
    }

    @Before("anyServiceAnnotatedOperation() || anyControllerOperation() ")
    public void beforeControllerAdvice2(JoinPoint joinPoint) {
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

}
