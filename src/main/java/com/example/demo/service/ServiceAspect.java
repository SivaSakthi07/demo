package com.example.demo.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Around(value = "execution(* com.example.demo.service.DemoService.*(..)) && args(..)")
    public Object beforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] methodArgs = joinPoint.getArgs();
        System.out.println("Entering method " + methodName + " in class " + className);
        System.out.println("Method arguments: " + getArgumentsAsString(methodArgs));
        Object result;
        try {
            // Proceed with the original method execution
            result = joinPoint.proceed();
        } catch (Throwable e) {
            // Handle any exceptions that occur during the method execution
            System.out.println("Exception occurred in method " + methodName + ": " + e.getMessage());
            throw e;
        }

        System.out.println("Exiting method " + methodName + " in class " + className + " with result: " + result);
        return result;

    }

//    @After(value = "execution(* com.example.demo.service.DemoService.*(..)) and args(str1,str2)")
//    public void afterAdvice(JoinPoint joinPoint, String str1, String str2) {
//        System.out.println("After method:" + joinPoint.getSignature());
//
//        System.out.println("Successfully executed with params - " + str1 + " and " + str2);
//    }


    @AfterReturning(value = "execution(* com.example.demo.service.DemoService.*(..)) && args(..)")
    public void afterAdviceReturning(JoinPoint joinPoint) {
        System.out.println("After Returning method:" + joinPoint.getSignature());

        System.out.println("Successfully executed ");
    }


    private String getArgumentsAsString(Object[] args) {
        StringBuilder sb = new StringBuilder();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                sb.append(arg).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());  // Remove trailing comma and space
        }
        return sb.toString();
    }

    @AfterThrowing(value = "execution(* com.example.demo.service.DemoService.*(..)) and args(str1,str2)")
    public void afterAdviceThrowing(JoinPoint joinPoint, String str1, String str2) {
        System.out.println("After Throwing method:" + joinPoint.getSignature());

        System.out.println("Exception with params - " + str1 + " and " + str2);
    }
}
