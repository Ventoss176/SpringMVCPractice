package com.ventoss.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date:2022/5/13
 * Author:Vent
 * Description:
 **/
@Controller
public class UserController {
    /**
     * get
     * post
     * put
     * delete
     * 在xml文件中配置/test_rest
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("获取全体数据");
        return "success";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("获取单个用户数据");
        return "success";
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(){
        System.out.println("添加单个用户数据");
        return "success";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String reUser(){
        System.out.println("修改单个用户数据");
        return "success";
    }
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUserById(){
        System.out.println("删除单个用户数据");
        return "success";
    }
}
