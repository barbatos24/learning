package com.zhoudewei.learningapplication.controller.redis;

import com.zhoudewei.learning.common.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author： zhoudewei
 * @date： 2022/1/4 5:21 下午
 * @description： redis接口
 * @version： v1.0
 */
@RestController
@RequestMapping("/learning/redis")
public class RedisController {

    public static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping(value = "/setString")
    public Boolean setString(@RequestBody Map<String,String> map){
        return redisUtils.set(map.get("name"),map.get("value"));
    }

    @GetMapping(value = "/getValue/{key}")
    public <T> T getValue(@PathVariable(value = "key") String key){
        if(redisUtils.exists(key)){
            return (T) redisUtils.get(key);
        }
        log.info("key:{} 不存在",key);
        return null;
    }
}

