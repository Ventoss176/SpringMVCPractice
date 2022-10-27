package com.ventoss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date:2022/6/13
 * Author:Vent
 * Description:
 **/
@Controller
public class TestController {
    @RequestMapping(value = "/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
    @RequestMapping(value = "/testError")
    public String testError(){
        System.out.println(1/0);
        return "success";
    }
}
