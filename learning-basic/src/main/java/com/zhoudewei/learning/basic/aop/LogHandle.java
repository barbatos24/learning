package com.zhoudewei.learning.basic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 2:16 下午
 * @description： 环绕增强，日志LogHandle
 * @version： v1.0
 */
@Service
public class LogHandle {

    public void printLog(ProceedingJoinPoint point){
        Object[] args = point.getArgs();
        for(Object arg : args){
            System.out.println("参数="+arg+" ");
        }
        try{
            Object object = point.proceed();
            System.out.println("返回值="+object);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        System.out.println("环绕增强：日志log");

    }

}
