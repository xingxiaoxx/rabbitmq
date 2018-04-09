package com.ideal.mq.listen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * 监听器基类
 * Created by xingxiao on 2017/11/13 0013.
 */
public abstract class BaseListener implements ChannelAwareMessageListener {

    public static String ERROR_QUEUE_SUFFIX = ".error" ;
    public static String RETRY_QUEUE_SUFFIX = ".retry" ;
    public static final String ERROR_MESSAGE_KEY="errorMsg";
    Logger  logger = Logger.getLogger(BaseListener.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            processMessage(message, channel);
        } catch (Exception e) {
            //此处可以根据自定义异常级别作相应的处理
            try {
                addError(message, channel, e);
            } catch (Exception e2) {
                //TODO 此处需要记录持久化日志，因为此次异常已经无法解决了，要保证消息不丢失
                logger.error(e2.getMessage());
            }
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }

    /**
     * 发生异常时将消息存入错误消息队列
     * @param message
     * @param channel
     * @throws Exception
     */
    private void addError(Message message, Channel channel,Exception e) throws Exception{
        byte[] errorMsgBody = null;
        try{
            JSONObject jsonObj = JSON.parseObject(new String(message.getBody()));
            jsonObj.put(ERROR_MESSAGE_KEY,e.getMessage());
            errorMsgBody = jsonObj.toJSONString().getBytes();
        }catch(JSONException e1){
            logger.error("Original Message Body: "+new String(message.getBody()));
            errorMsgBody = message.getBody();
        }


        String queueName = message.getMessageProperties().getConsumerQueue() ;
        String errorQueueName = queueName + ERROR_QUEUE_SUFFIX ;

        channel.queueDeclare(errorQueueName, true, false, false, null) ;
        channel.basicPublish("", errorQueueName,
                MessageProperties.PERSISTENT_TEXT_PLAIN, errorMsgBody);
    }


    protected abstract void processMessage(Message message,Channel channel) throws Exception ;

}
