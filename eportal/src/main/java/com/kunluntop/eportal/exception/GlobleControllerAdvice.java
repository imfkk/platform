package com.kunluntop.eportal.exception;

import com.kunluntop.eportal.base.BaseResult;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobleControllerAdvice {

    /**
     * 全局异常处理，反正异常返回统一格式的map
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandler(Exception ex) {
        if (ex instanceof UnauthenticatedException){
            return  BaseResult.fail(100,"请先登录",new Object());
        }
        if (ex instanceof UnauthorizedException){
            return  BaseResult.fail(110,"权限不足",new Object());
        }
        return BaseResult.fail(200,"系统异常",new Object());
    }
}
