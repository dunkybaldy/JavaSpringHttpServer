package com.springhttpserver.Services;

import com.springhttpserver.Models.HelloData;

public interface IHelloService {
    String GetGreetingMessage();
    HelloData GetUserData(String userId);
}
