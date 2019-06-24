package com.example.demo.restTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UrlService {

    @Autowired
    private RestTemplate restTemplate;

    public String getSeesion(){
        return restTemplate.getForObject("http://localhost:8090/sessionController/getSessionId",String.class);
    }

    public ResponseEntity<String> getSeesionByKey(@PathVariable(name = "key")String key){
        return restTemplate.getForEntity("http://localhost:8090/sessionController/getSession/{key}",String.class,key);
    }
}
