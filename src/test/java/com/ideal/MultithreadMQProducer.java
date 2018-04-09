package com.ideal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("multithreadMQProducer")
public class MultithreadMQProducer extends MQProducerBase {

    @Autowired
    private ExecutorFactory executorFactory;


//    final static ExecutorService pool = Executors.newFixedThreadPool(20);

    public void send(final String exchange, final String routingKey, final String message){

        executorFactory.runTask(new Runnable() {
            @Override
            public void run() {
                sendToExchange(exchange, routingKey, message);
            }
        });

    }

}
