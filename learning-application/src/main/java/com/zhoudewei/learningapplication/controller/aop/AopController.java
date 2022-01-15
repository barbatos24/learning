package com.zhoudewei.learningapplication.controller.aop;

import com.zhoudewei.learningapplication.resp.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 5:02 下午
 * @description： Aop测试控制层
 * @version： v1.0
 */
@RestController
@RequestMapping(value = "/aop")
public class AopController {

    private static final Logger logger = LoggerFactory.getLogger(AopController.class);

    @GetMapping(value = "/achieve")
    public HttpResult<String> achieve(){
       logger.info("achieve()方法执行-----------");
       return HttpResult.success("OK");

    }


}
