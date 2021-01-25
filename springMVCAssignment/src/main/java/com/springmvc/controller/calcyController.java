package com.springmvc.controller;

import com.springmvc.exceptions.largeNumberExceptionAdvice;
import com.springmvc.service.calculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calcyController {

    @Autowired
    calculatorService cal ;

    @RequestMapping(value = "/calcy", method = RequestMethod.GET)
    public String openCalculator(){
        return "calculator";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(@RequestParam String result, ModelMap model){
        model.put("result", result);
        return "Result";
    }

    @RequestMapping(value = "/calcy", method = RequestMethod.POST)
    public String calculate (@RequestParam String num1, @RequestParam String num2,@RequestParam String operation, ModelMap model) throws Exception{
        int result = cal.bodmassOP(num1, num2 , operation);
        if(result>1000)
        {
            throw new largeNumberExceptionAdvice();
        }
        model.put("result", result);
        return "Result";
    }
}
