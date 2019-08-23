package com.kunluntop.eportal.service.impl;

import com.kunluntop.eportal.service.HelloService;
import com.kunluntop.mapper.TbCarMapper;
import com.kunluntop.pojo.TbCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public TbCar getCar() {
        TbCar car = carMapper.selectByPrimaryKey(1);
        return car;
    }
}
