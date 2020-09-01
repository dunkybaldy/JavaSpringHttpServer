package com.springhttpserver.DataAccess;

import com.springhttpserver.Models.HelloData;

import java.util.Map;

public interface IHelloDataAccess {
    void AddData(HelloData helloData);
    void RemoveData(String Name);
    HelloData GetData(String Name);
    Map<String, HelloData> GetAllData();
}
