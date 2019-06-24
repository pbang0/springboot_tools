package com.example.demo.async.task;

import com.example.demo.async.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

@Slf4j
@Component
public class AsyncTask {

    public Future<Boolean> task() throws InterruptedException{
        AsyncTask asyncTaskService = SpringUtil.getBean(AsyncTask.class);
        asyncTaskService.task1();
        asyncTaskService.task2();
        log.info("task 使用线程 ：" + Thread.currentThread().getName());
        return new AsyncResult<>(true);

    }

    @Async("poolExecutor")
    public Future<Boolean> task1() throws InterruptedException{
        log.info("task1 使用线程 ：" + Thread.currentThread().getName());
        Thread.sleep(3000);
        return new AsyncResult<>(true);
    }

    @Async("poolExecutor")
    public Future<Boolean> task2() throws InterruptedException{
        log.info("task3 使用线程 ：" + Thread.currentThread().getName());
        Thread.sleep(3000);
        return new AsyncResult<>(true);
    }
}
