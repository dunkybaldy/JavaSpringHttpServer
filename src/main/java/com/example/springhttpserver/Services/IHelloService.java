package com.example.springhttpserver.Services;

import com.example.springhttpserver.Models.HelloData;

public interface IHelloService {
    String GetGreetingMessage();
    HelloData GetUserData(String userId);
}
