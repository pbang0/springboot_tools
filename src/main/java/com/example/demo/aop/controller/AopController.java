package com.example.demo.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aopController")
public class AopController {
    @RequestMapping(value="/sayHello" ,method = RequestMethod.GET)
    public String sayHello(String name){
        return "Hello "+ name ;
    }
}
