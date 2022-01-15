package com.zhoudewei.learning.basic.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


/**
 * @author： zhoudewei
 * @date： 2022/1/14 2:23 下午
 * @description： 前后增强，计算时间TimeHandle
 * @version： v1.0
 */
@Service
public class TimeHandle {

    public void printTime(){
        System.out.println("CurrentTime="+System.currentTimeMillis());
    }


}
