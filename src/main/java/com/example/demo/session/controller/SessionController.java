package com.example.demo.session.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sessionController")
public class SessionController {

    @RequestMapping(value="/getSessionId",method = RequestMethod.GET)
    @ResponseBody
    public String getSessionId(HttpServletRequest request){

        Object o = request.getSession().getAttribute("springboot");
        if(o == null){
            o = request.getLocalPort();
            request.getSession().setAttribute("springboot", o);
        }

        return " 端口 = " + request.getLocalPort() +  " sessionId = " + request.getSession().getId() + o;
    }

    @RequestMapping(value="/getSession/{key}",method = RequestMethod.GET)
    @ResponseBody
    public String getSessionIdByKey(@PathVariable(name = "key") String key, HttpServletRequest request){

        Object o = request.getSession().getAttribute(key);
        if(o == null){
            return " 所需session不存在  " ;
        }else {
            return " 所需session存在 ： sessionId = " + request.getSession().getId() + o;
        }
    }


}
