package com.kunluntop.eportal.service.impl;

import com.kunluntop.eportal.service.HelloService;
import com.kunluntop.mapper.TbCarMapper;
import com.kunluntop.pojo.TbCar;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10919
 * @title: HelloServiceImpl
 * @projectName platform
 * @description: TODO
 * @date 2019/8/2116:27
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private TbCarMapper carMapper;
    @Override
    public TbCar getCar(){
       TbCar car=  carMapper.selectByPrimaryKey(1);
       return  car;
    }
}
