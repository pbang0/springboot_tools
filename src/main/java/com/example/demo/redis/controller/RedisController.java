package com.example.demo.redis.controller;

import com.example.demo.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/redis")
@Slf4j
public class RedisController {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "setRedis",method = RequestMethod.POST)
    @ResponseBody
    public String getRedis(){
        redisUtil.set("20192019","Teststr", 0);
        //设置key过期时间
        Long resExpire = redisUtil.expire("20182019", 60, 0);
        log.info("resExpire="+resExpire);
        String res = redisUtil.get("20192019", 0);
        return  res + "执行成功";
    }

}

