package com.kunluntop.eportal.controller;

import com.kunluntop.eportal.base.BaseResult;
import com.kunluntop.eportal.service.HelloService;
import com.kunluntop.pojo.TbCar;
import com.kunluntop.redis.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @RequiresPermissions("test")
    public TbCar hello(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // session.setAttribute("aa","aa");
        System.out.println(session.getAttribute("aa"));
        redisUtil.set("asda","asda",-1);
        TbCar car = helloService.getCar();
        return car;
    }

    @RequestMapping("/login")
    @ResponseBody
    public BaseResult login(){

        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("admin","123456");
        Subject currentUser = SecurityUtils.getSubject();//获取当前用户信息
        try {
            currentUser.login(usernamePasswordToken);//登陆验证
        } catch (UnknownAccountException uae) {
            BaseResult.fail(120,"账号不存在",new Object());
        } catch (IncorrectCredentialsException ice) {
            BaseResult.fail(121,"密码错误",new Object());
        } catch (LockedAccountException lae) {
            BaseResult.fail(121,"账号锁定",new Object());
        } catch (ExcessiveAttemptsException eae) {
            BaseResult.fail(121,"登录过于频繁",new Object());
        } catch (AuthenticationException ae) {
            BaseResult.fail(121,"登录异常",new Object());
        }
        return BaseResult.success("登录成功","");
    }

}
