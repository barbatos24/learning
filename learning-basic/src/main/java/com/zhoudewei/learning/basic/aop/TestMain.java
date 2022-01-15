package com.zhoudewei.learning.basic.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 2:04 下午
 * @description： 面向切面demo入口
 * @version： v1.0
 */
public class TestMain {

    public static void main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImplFirst");
        hw1.printHelloWorld("xiaoming");

    }
}
