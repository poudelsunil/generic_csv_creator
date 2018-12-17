package com.example.gcsvcreator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "CSV creator";
    }

}
