package com.ideal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;


@Service
public class ExecutorFactory {

    @Autowired
    private ThreadPoolTaskExecutor threadPool;


    public void runTask(Runnable runnable){
        threadPool.execute(runnable);
    }

    public ThreadPoolTaskExecutor getThreadPool() {
        return threadPool;
    }


}
