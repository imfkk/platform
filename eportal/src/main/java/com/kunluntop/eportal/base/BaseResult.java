package com.kunluntop.eportal.base;

import java.util.HashMap;
import java.util.List;

/**
 * @author 10919
 * @title: BaseResult
 * @projectName platform
 * @description: TODO
 * @date 2019/8/2316:33
 */
public class BaseResult {

    private Integer state;
    private Integer code;
    private String message;
    private Object data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResult success(String msg,Object data){
        BaseResult ret=new BaseResult();
        ret.setState(0);
        ret.setCode(0);
        ret.setMessage(msg);
        ret.setData(data);
        return ret;
    }

    public static BaseResult fail(Integer errorCode,String msg,Object data){
        BaseResult ret=new BaseResult();
        ret.setState(1);
        ret.setCode(errorCode);
        ret.setMessage(msg);
        ret.setData(data);
        return ret;
    }
}
