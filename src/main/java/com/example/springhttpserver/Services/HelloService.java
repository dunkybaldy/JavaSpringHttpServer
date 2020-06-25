package com.example.springhttpserver.Services;

import com.example.springhttpserver.DataAccess.HelloDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {
    private HelloDataAccess dataAccess;

    @Autowired
    public HelloService(HelloDataAccess helloDataAccess) {
        dataAccess = helloDataAccess;
    }


    public String GetGreetingMessage() {
        return "Hello welcome to the test.";
    }

    public String GetUserData(String userId) {
        return dataAccess.Data1();
    }
}
