package com.example.demo.retry.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@Slf4j
public class PayService {

    private final int totalNum = 100000;

    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public int minGoodsum(int num) throws Exception{
        log.info("minGood_sum 开始"+ LocalTime.now());
        if(num <= 0){
            throw new Exception("数量不对");
        }
        log.info("minGood_sum 执行结束");
        return totalNum - num;
    }

    @Recover
    public int recover(Exception e){
        log.warn("减库存失败！！！");
        //记日志到数据库
        return totalNum;
    }
}
