package com.example.demo.retry.controller;

import com.example.demo.retry.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class retryController {
    @Autowired
    PayService payService ;

    @GetMapping("/createOrder")
    public String createOrder(@RequestParam int num) throws Exception{
        int remainmingnum = payService.minGoodsum(num == 0 ? 1: num);
        log.info("剩余的数量 ---> " + remainmingnum);
        return "库存成功";
    }
}
