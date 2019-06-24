package com.example.demo.restTemplate.controller;


import com.example.demo.restTemplate.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/restController")
public class RestTemplateController {

    @Autowired
    private UrlService urlService;

    @RequestMapping(value="/getSessionIdByUrl",method = RequestMethod.GET)
    @ResponseBody
    public String getSessionId(HttpServletRequest request){
        return urlService.getSeesion();
    }
    @RequestMapping(value="/getSessionIdByKey/{key}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getSessionIdByKey(@PathVariable(name = "key") String key, HttpServletRequest request){
        return urlService.getSeesionByKey(key);
    }
}
