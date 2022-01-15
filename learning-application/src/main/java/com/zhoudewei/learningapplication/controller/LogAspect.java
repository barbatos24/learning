package com.zhoudewei.learningapplication.controller;

import com.zhoudewei.learningapplication.resp.HttpResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 4:52 下午
 * @description： Spring AOP @After,@Around,@Before
 * @version： v1.0
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    static{
        logger.info("LogAspect类开始加载");
    }

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 第一个*代表返回类型不限
     * 第二个*代表所有类
     * 第三个*代表所有方法
     * (..) 代表参数不限
     */
    @Pointcut("execution(public * com.zhoudewei.learningapplication.controller.aop.AopController.*(..))")
    @Order(1)
    public void pointCut(){
        logger.info("创建PointCut成功");
    }


    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("方法执行前执行......before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("<=====================================================");
        logger.info("请求来源： =》" + request.getRemoteAddr());
        logger.info("请求URL：" + request.getRequestURL().toString());
        logger.info("请求方式：" + request.getMethod());
        logger.info("响应方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
        logger.info("------------------------------------------------------");
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 定义需要匹配的切点表达式，同时需要匹配参数
     * @param pjp
     * @param arg
     * @return
     * @throws Throwable
     */
    @Around("pointCut() && args(arg)")
    public <T> HttpResult<T> around(ProceedingJoinPoint pjp, String arg) throws Throwable{
        System.out.println("name:" + arg);
        System.out.println("方法环绕start...around");
        String result = null;
        try{
            result = pjp.proceed().toString() + "aop String";
            System.out.println(result);
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("方法环绕end...around");
        return (HttpResult) pjp.proceed();
    }


    @After("within(com.zhoudewei.learningapplication.controller.aop.*Controller)")
    public void after(){
        System.out.println("方法之后执行...after.");
    }


    @AfterReturning(pointcut="pointCut()",returning = "rst")
    public void afterRunning(HttpResult rst){
        if(startTime.get() == null){
            startTime.set(System.currentTimeMillis());
        }
        System.out.println("方法执行完执行...afterRunning");
        logger.info("耗时（毫秒）：" +  (System.currentTimeMillis() - startTime.get()));
        logger.info("返回数据：{}", rst);
        logger.info("==========================================>");
    }


    @AfterThrowing("within(com.zhoudewei.learningapplication.controller.aop.*Controller)")
    public void afterThrowing(){
        System.out.println("异常出现之后...afterThrowing");
    }


}
