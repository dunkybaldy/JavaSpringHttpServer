package com.example.springhttpserver.Controllers;

import com.example.springhttpserver.Services.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private IHelloService _service;

    @Autowired
    public HelloController(IHelloService service) {
        _service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String HelloWorld()
    {
        return _service.GetGreetingMessage();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public void GetData(@RequestParam String userId)
    {
//        return logic.GetSomethingFromData();
    }
}
