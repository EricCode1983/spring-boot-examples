package com.example.basic.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        String sentence = "Hello World";
        System.out.println(sentence);
        return sentence;

    }

    @RequestMapping(value="/hi", method = RequestMethod.GET)
    public String hi(){
        String sentence = "Hi World";
        System.out.println(sentence);
        return sentence;
    }
}
