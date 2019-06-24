package com.example.demo.schedule.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 秒   分  时  日期 月  星期
 * 0/30 *   *   *   *   * : 每30秒执行一次
 * 0    0/5 *   *   *   * : 每5分钟执行一次
 * 0    0   0   *   *   * : 每天0点执行一次
 * 0    0   5,7 *   *   * : 每天5点7点整执行一次
 * 0    30  3-5 *   *   * : 每天3-5点的30分执行一次
*/


@Component
@Slf4j
public class Task {
    private int i = 0;
//    @Scheduled(cron = "0/10 * * * * *")
    public void work() {
        log.info("第 "+ ++i +" 次执行");
    }
}
