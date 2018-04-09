package com.ideal.aop;

import com.alibaba.fastjson.JSON;
import com.ideal.exception.IdealException;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * service层的统一异常处理
 * Created by xingxiao on 2017/11/13 0013.
 */
public class IdealServiceExceptionAspect {

    Logger logger = LoggerFactory.getLogger(IdealServiceExceptionAspect.class);

    public void doThrowing(JoinPoint jp, IdealException ex) {
        //可根据异常类型打印不同日志或者作不同业务处理
        logger.error(JSON.toJSONString(ex));
    }

}
