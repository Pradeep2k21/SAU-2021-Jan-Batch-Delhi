package com.springmvc.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class largeNumberExceptionAdvice extends Exception{

    public largeNumberExceptionAdvice(){
        super("Large Number Error: number > 1000");
    }

    @ExceptionHandler(value = largeNumberExceptionAdvice.class)
    public ModelAndView largerNumberHandling() {

        ModelAndView mvobj = new ModelAndView();
        mvobj.addObject("exception", "Large Number Error: number > 1000");
        mvobj.setViewName("largeNumberError");
        return mvobj;
    }

}

