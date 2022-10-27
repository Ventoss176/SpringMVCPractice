package com.ventoss.springmvc.controller;

import com.ventoss.springmvc.Bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2022/6/9
 * Author:Vent
 * Description:
 **/
@Controller
public class HttpController {

    @RequestMapping(value = "/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:" + requestBody);
        return "success";
    }
    @RequestMapping(value = "/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("requestHeaders:" + requestEntity.getHeaders());
        System.out.println("requestBody:" + requestEntity.getBody());
        return "success";
    }
    //原生HttpServletResponse
    @RequestMapping(value = "/testHttpResponse")
    public void testHttpResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello, like");
    }

    @RequestMapping(value = "/testResponseBody", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testResponseBody(){
        return "成功页面";
    }

    @RequestMapping(value = "/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"admin","114514",23,"男");
    }
    @RequestMapping(value = "/testAxios")
    @ResponseBody
    public String testAxios(String username, String password){
        System.out.println(username + password);
        return "hello,Axios";
    }


}
