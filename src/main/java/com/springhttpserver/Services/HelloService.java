package com.springhttpserver.Services;

import com.springhttpserver.DataAccess.HelloDataAccess;
import com.springhttpserver.Models.HelloData;
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

    public HelloData GetUserData(String userId) {
        return dataAccess.GetData(userId);
    }
}
