package com.ventoss.springmvc.controller;

import com.ventoss.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Date:2022/5/3
 * Author:Vent
 * Description:
 **/


@Controller
//@RequestMapping("/help")
public class TestController {
    @RequestMapping(value = "/")
    public String index() {
        //设置视图名称
        return "index";//文件名
    }
    /**
     * 【】1.默认为get,练习post，get，put请求方式、派生注解@GetMapping、@PostMapping等，form表单默认Method问题【】【】【】
     * 【】2.多个RequestMapping(value值)【】
     * 【】3.param,headers练习@RequsetMapping(params = {}, headers = {})【】
     * 【】4.value = "/a?a/test" /a*a，?，*，**的用法【】
     * 【】5.rest方式传输参数@PathVariable 【】
     * 【】6.HttpServletRequest request在这用法，无法用rest方式（一般不使用6.方式，属于老方法）
     * 【】7.方法参数直接(String username, String password, String[] hobby)
     * 【】8.@RequestParm(value = "user_name", required = false, defaultValue = hehe)String username; required 为是否必要传输
     * 【】9.@RequestHeaders同理
     * 【】10.实体请求参数
     * 【】11.设置编码乱码问题，get方法乱码出在tomcat配置文件
     * 【】12.fillter优先初始化
     *  day02
     *  13.回顾域对象，seesion域这种，浏览器关闭有关系等等
     *
     *
     *
     */
    /**
     *
     * "param"：要求请求映射所匹配的请求必须携带param请求参数
     *
     * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
     *
     * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
     *
     * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
     *
     */
    @RequestMapping(
            value = {"/target", "/help"},
            method = {RequestMethod.POST}
    )
    public String toTarget(){
        return "target";
    }
    //测参数
    @RequestMapping(
            value = {"/target", "/help"},
            method = {RequestMethod.POST, RequestMethod.GET},
            params = {"username", "password=123", "card!=abc"}
    )
    public String toTarget2(){
        return "target";
    }

    @RequestMapping(
            value = {"/c*c/{id}/{username}", "/a?a", "/**/ddd"}
            //params = {"username", "password=123", "card!=abc"}
    )
    public String toTarget3(@PathVariable("id")String id,
                            @PathVariable("username")String username){
        System.out.println(id + username);
        return "target";
    }

    //HttpServelet获取参数
    @RequestMapping(
            value = {"/target1", "/help1"},
            method = {RequestMethod.POST, RequestMethod.GET},
            params = {"username", "password=123", "card!=abc"}
    )
    public String toTarget4(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);

        return "target";
    }

    @RequestMapping(
            value = {"/target2", "/help2"}
    )
    public String toTarget5(String username, String password){

        System.out.println(username + password);

        return "target";
    }

    @RequestMapping(
            value = {"/testpojo"}
    )
    public String toTarget6(User user){
        System.out.println(user);
        return "target";
    }

}
