package com.springhttpserver.TestDataAccess;

import com.springhttpserver.DataAccess.IHelloDataAccess;
import com.springhttpserver.Models.HelloData;

import java.util.HashMap;
import java.util.Map;

public class THelloDataAccess implements IHelloDataAccess {

    public Map<String, HelloData> database;

    public THelloDataAccess() {
        database = new HashMap<String, HelloData>();
    }

    @Override
    public void AddData(HelloData helloData) {
        database.put(helloData.Name, helloData);
    }

    @Override
    public void RemoveData(String Name) {
        database.remove(Name);
    }

    @Override
    public HelloData GetData(String Name) {
        return database.get(Name);
    }

    @Override
    public Map<String, HelloData> GetAllData() {
        return database;
    }
}
