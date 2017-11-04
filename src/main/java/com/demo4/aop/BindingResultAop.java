package com.demo4.aop;

import net.sf.json.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BindingResultAop {

    private ObjectError error;

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
                Map<String,String> result=new HashMap<>();
            //    for(ObjectError error :errors){
                for(ObjectError error :errors){
                    FieldError er=(FieldError)error;
                    msg.append(error.getDefaultMessage());
                    msg.append("\n");
                    result.put(er.getField(),er.getDefaultMessage());
                }
           //   return new JSONView(new HashMap().add("result",false).add("message",msg.toString()));
             // return null;
                JSONObject jsonO = JSONObject.fromObject(result);
                return result;
            }
        }
        return joinPoint.proceed();
    }
}
