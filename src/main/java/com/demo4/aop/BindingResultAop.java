package com.demo4.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;

public class BindingResultAop {

    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult bindingResult = null;
        for(Object arg:joinPoint.getArgs()){
            if(arg instanceof BindingResult){
                bindingResult = (BindingResult) arg;
            }
        }
        if(bindingResult != null){
            List<ObjectError> errors = bindingResult.getAllErrors();
            if(errors.size()>0){
                StringBuilder msg = new StringBuilder();
                for(ObjectError error :errors){
                    msg.append(error.getDefaultMessage());
                    msg.append("\n");
                }
            ///   return new JSONView(new HashMap().add("result",false).add("message",msg.toString()));
                return null;
            }
        }
        return joinPoint.proceed();
    }
}
