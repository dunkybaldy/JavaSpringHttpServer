package com.example.springhttpserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/home")
    public String HelloWorld()
    {
        return "Hello World";
    }
}
