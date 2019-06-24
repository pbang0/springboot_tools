package com.example.demo.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/first")
public class FirstController {
    @RequestMapping(value="/sayHello" ,method = RequestMethod.GET)
    public String sayHello(String name){
        return "Hello "+ name ;
    }
}