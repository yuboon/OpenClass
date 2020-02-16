package com.yuboon.springboot.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author yuboon
 * @version v1.0
 * @date 2020/01/20
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public HttpServletRequest hello(String name, HttpServletRequest request){
        /*String nullString = null;
        nullString.toString();*/
        return request;
    }


}
