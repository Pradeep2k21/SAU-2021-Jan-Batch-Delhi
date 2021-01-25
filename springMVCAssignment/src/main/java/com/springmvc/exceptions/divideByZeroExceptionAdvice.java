package com.springmvc.exceptions;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class divideByZeroExceptionAdvice extends Exception {

    public divideByZeroExceptionAdvice()
    {
        super("Division by zero");
    }

    @RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = divideByZeroExceptionAdvice.class)
    public @ResponseBody
    HashMap<String, String> handleError(HttpServletRequest req, Exception exception) {

        HashMap<String,String> errorObject=new HashMap<>();
        errorObject.put("Operation","/");
        errorObject.put("Message","Divide By Zero Error");
        return errorObject;
    }
}
