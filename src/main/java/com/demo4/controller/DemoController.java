package com.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class DemoController {

    @RequestMapping(value="/demo")
    public String view(){
        return "demo";
    }

    @RequestMapping(value="/demo2")
    @ResponseBody
    public Object view(@Valid Subscriber sub, BindingResult result){
        if(result.hasErrors()) {
           return result.getAllErrors();
        }
        return "demo";
    }
}
