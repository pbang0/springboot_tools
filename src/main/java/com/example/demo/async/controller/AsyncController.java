package com.example.demo.async.controller;

import com.example.demo.async.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/asyncController")
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask ;

    @RequestMapping(value = "/doTask",method = RequestMethod.GET)
    public String doTask() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        asyncTask.task();
        long currentTimeMillis1 = System.currentTimeMillis();
        return "task 任务总耗时 :"+(currentTimeMillis1-currentTimeMillis)+"ms";

    }

}
