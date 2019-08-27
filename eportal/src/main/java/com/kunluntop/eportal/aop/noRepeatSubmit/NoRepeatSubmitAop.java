package com.kunluntop.eportal.aop.noRepeatSubmit;

import com.kunluntop.eportal.exception.RepeatSubmitException;
import com.kunluntop.redis.RedisUtil;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
/**
 * 防止重复提交
 */
public class NoRepeatSubmitAop {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private RedisUtil redisUtil;


    @Around("@annotation(nrs)")
    public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key ="repeatsubmit:"+ sessionId + ":" + request.getServletPath();
            if (redisUtil.get(key) == null) {// 如果缓存中有这个url视为重复提交
                    redisUtil.set(key,"",3*1000);
                    Object o=null;
                    try {
                        o = pjp.proceed();
                    }catch (Throwable e){
                        e.printStackTrace();
                        logger.error("验证重复提交时出现未知异常!");
                        throw  new RuntimeException("验证重复提交时出现未知异常!");
                    }
                    redisUtil.del(key);
                    return o;
            } else {
                logger.error("重复提交:"+request.getServletPath());
                throw  new RepeatSubmitException("重复提交");
            }
    }

}
