package com.ventoss.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 **/
@Controller
public class HelloController {
    String d = "sasdas";
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/hello")
    public String toTarget(){
        return "target";
    }
}
