package com.ideal.mq.listen;

import com.rabbitmq.client.Channel;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 短消息监听器
 * Created by xingxiao on 2017/11/13 0013.
 */
public class SmsListener extends BaseListener{

    Logger logger = LoggerFactory.getLogger(SmsListener.class);

    protected void processMessage(Message message, Channel channel) throws Exception {

        String msg = new String(message.getBody());
        logger.info("sms消息 ：" + msg);
    }
}
