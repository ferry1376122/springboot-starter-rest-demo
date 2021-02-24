package com.study.springbootstarterrestdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 来苏
 */
@Controller
public class UsersController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello,welcome to my normal controller!";
    }
}
