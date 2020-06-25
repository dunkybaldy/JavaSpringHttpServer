package com.example.springhttpserver.DataAccess;

import com.example.springhttpserver.Models.HelloData;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HelloDataAccess implements IHelloDataAccess {
    // database connection

    public HelloDataAccess() {}


    @Override
    public void AddData(HelloData helloData) {

    }

    @Override
    public void RemoveData(String Name) {

    }

    @Override
    public HelloData GetData(String Name) {
        return null;
    }

    @Override
    public Map<String, HelloData> GetAllData() {
        return null;
    }
}
