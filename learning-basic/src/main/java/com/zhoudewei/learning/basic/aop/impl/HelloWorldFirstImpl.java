package com.zhoudewei.learning.basic.aop.impl;

import com.zhoudewei.learning.basic.aop.HelloWorld;
import org.springframework.stereotype.Service;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 2:26 下午
 * @description： HelloWorld接口的实现类
 * @version： v1.0
 */
@Service
public class HelloWorldFirstImpl implements HelloWorld {

    @Override
    public String printHelloWorld(String name) {
        System.out.println("我是演示方法printHelloWorld");
        return "first";
    }
}
