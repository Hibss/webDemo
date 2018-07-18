package com.jfz.thymeleaf.controller.dataController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : steven.sheng
 * Description : TODO
 * Date : 2018/4/27 17:32
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/")
    public String home(){
        return "webDemo ready";
    }

}
