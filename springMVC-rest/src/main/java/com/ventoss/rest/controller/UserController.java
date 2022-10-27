package com.ventoss.rest.controller;

import com.ventoss.rest.bean.Employee;
import com.ventoss.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Date:2022/6/3
 * Author:Vent
 * Description:
 **/
@Controller
public class UserController {
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }
    // @RequestMapping(value = "/toAdd", method = RequestMethod.POST)
    // public String addEmployee(@PathVariable Employee employee){
    //     employeeDao.save(employee);
    //     return "Emloyee_list";
    // }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
        //自动变成employee原理
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

}
