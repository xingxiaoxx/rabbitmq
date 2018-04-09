package com.ideal.service.impl;

import com.ideal.exception.IdealException;
import com.ideal.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 推送service
 * Created by xingxiao on 2017/11/13 0013.
 */

@Service
public class PushServiceImpl implements PushService{

    Logger logger = LoggerFactory.getLogger(PushServiceImpl.class);

    @Override
    public void push(String msg) {

        logger.info(msg+ "=========");

        throw new IdealException("异常异常", "0");
    }
}
