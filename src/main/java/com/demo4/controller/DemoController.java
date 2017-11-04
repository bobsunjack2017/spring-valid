package com.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @RequestMapping(value="/demo")
    public String view(){
        return "demo";
    }

    @RequestMapping(value="/demo2")
    @ResponseBody
    public Object view(@Validated(SubscriberGroup.Add.class) Subscriber sub, BindingResult result){
        if(result.hasErrors()) {
           return result.getAllErrors();
        }
        return "demo";
    }

    @RequestMapping(value="/demo4")
    @ResponseBody
    public Object view2(@Validated Subscriber sub, BindingResult result){
        if(result.hasErrors()) {
            return result.getAllErrors();
        }
        return "demo";
    }


    @RequestMapping(value="/demo3")
    public ModelAndView test(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","fengxiang");
        map.put("age",23);
        return new ModelAndView("jsonView").addObject(map);
    }
}
