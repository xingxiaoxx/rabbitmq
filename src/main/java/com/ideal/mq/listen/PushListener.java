package com.ideal.mq.listen;

import com.ideal.service.PushService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 推送监听器
 * Created by xingxiao on 2017/11/13 0013.
 */
public class PushListener extends BaseListener{

    Logger logger = LoggerFactory.getLogger(PushListener.class);

    @Autowired
    private PushService pushService;

    protected void processMessage(Message message, Channel channel) throws Exception {

        String msg = new String(message.getBody());
        pushService.push(msg);
    }
}
