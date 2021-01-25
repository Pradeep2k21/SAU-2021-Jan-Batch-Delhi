package com.springmvc.service;

import com.springmvc.exceptions.divideByZeroExceptionAdvice;
import org.springframework.stereotype.Service;

@Service
public class calculatorService {

    public int bodmassOP(String num1, String num2,String operation) throws divideByZeroExceptionAdvice {

        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);
        Integer result = 0;

        switch (operation){

            case "add":
                result = number1 + number2;
                break;
            case "sub":
                result = number1 - number2;
                break;
            case "mul":
                result = number1 * number2;
                break;
            case "div":
                if(number2 == 0)
                    throw new divideByZeroExceptionAdvice();
                result = number1 / number2;
                break;

        }
        return result;
    }

}
