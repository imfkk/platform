package com.kunluntop.eportal.aop;

import com.kunluntop.eportal.exception.RepeatSubmitException;
import com.kunluntop.eportal.utils.base.BaseResult;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
        if (ex instanceof UnauthenticatedException) {
            return BaseResult.fail(100, "请先登录", new Object());
        }
        if (ex instanceof UnauthorizedException) {
            return BaseResult.fail(110, "权限不足", new Object());
        }
        if (ex instanceof RepeatSubmitException){
            return BaseResult.fail(110, "重复提交", new Object());
        }
        return BaseResult.fail(200, "系统异常", new Object());
    }
}
