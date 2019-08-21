package com.kunluntop.eportal.controller;

import com.kunluntop.eportal.service.HelloService;
import com.kunluntop.pojo.TbCar;
import com.kunluntop.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 10919
 * @title: HelloWorld
 * @projectName platform
 * @description: TODO
 * @date 2019/8/2116:01
 */
@Controller
@RequestMapping(value = "/helloworld")
@ResponseBody
public class HelloWorld {
    @Autowired
    private HelloService helloService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/hello")
    public TbCar hello() {

         Object a= redisUtil.get("asda");
        TbCar car=helloService.getCar();
        return car;
    }
}
