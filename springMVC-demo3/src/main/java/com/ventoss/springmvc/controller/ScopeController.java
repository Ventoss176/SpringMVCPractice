package com.ventoss.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Date:2022/5/13
 * Author:Vent
 * Description:
 **/

/**
 * 1.request.setAttribute()
 * 2.ModelAndView 向Request域共享数据， 新建一个MAV类，来调用，还能设置视图名称
 * 3.Model Map ModelMap等想Request域共享数据
 * 4.ModelAndView ModelMap源码分析
 * 5.回顾各种域
 * 6.ThymeleafView
 * 7.RedirectView ***重要！！！：重定向和转发区别
 * 8.springMVC.xml中配置控制器，java文件中全部失效，需要注解驱动
 * 9.RESTFul模拟用户资源的增删改查user post get
 * 10.配置HiddenHttpMethodFilter
 *
 *
 *
 *
 *
 */
@Controller
public class ScopeController {
    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/tesRequestByServeletAPI")
    public String tesRequestByServeletAPI(HttpServletRequest request){
        request.setAttribute("space", "work here");
        return "success";
    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("MAVSpace", "MAV work here");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("ModSpace", "ModWorkHere");
        return "success";
    }
    @RequestMapping("/testMap")
    public String testMap(Map map){
        map.put("Map", "MapWorkHere");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testMap(ModelMap modelmap){
        modelmap.addAttribute("ModelMap", "ModWorkHere");
        return "success";
    }

    //Model、ModelMap、Map类型的参数其实本质上都是 BindingAwareModelMap 类型的
    /**
     * public interface Model{}
     * public class ModelMap extends LinkedHashMap<String, Object> {}
     * public class ExtendedModelMap extends ModelMap implements Model {}
     * public class BindingAwareModelMap extends ExtendedModelMap {}
     */
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("SessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("ApplicationScope", "hello,application");
        return "success";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testModelMap";
    }

}
