package com.ventoss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date:2022/6/14
 * Author:Vent
 * Description:
 **/
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
