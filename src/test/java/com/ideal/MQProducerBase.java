package com.ideal;


import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQProducerBase {
    private static final String EXCHANGE_DEFAULT = "gwy.topic";
    private static final String ROUTING_DEFAULT = "notice.1";
    @Autowired
    AmqpTemplate amqpTemplate;

    public boolean sendToExchange(String exchange, String routingKey, String message) {
        if (StringUtils.isEmpty(exchange)) {
            exchange = EXCHANGE_DEFAULT;
        }
        if (StringUtils.isEmpty(routingKey)) {
            routingKey = ROUTING_DEFAULT;
        }

        long startTime = System.currentTimeMillis();
        try {
            amqpTemplate.convertAndSend(exchange, routingKey, message);
        } finally {
            long endTime = System.currentTimeMillis();
        }
        return true;
    }

}
