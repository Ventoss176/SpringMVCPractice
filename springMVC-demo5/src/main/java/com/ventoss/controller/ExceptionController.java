package com.ventoss.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Date:2022/6/14
 * Author:Vent
 * Description:
 **/
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(Exception exception, Model model){
        model.addAttribute("ex", exception);
        return "error";
    }
}
