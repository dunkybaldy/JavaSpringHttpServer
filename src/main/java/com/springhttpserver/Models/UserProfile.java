package com.springhttpserver.Models;

import java.util.UUID;


public class UserProfile {
    private String Id; // GUID
    private String Name;
    private int Age;

    public UserProfile()
    {
        SetId();
    }

    public UserProfile(String name, int age)
    {
        SetId();
        SetName(name);
        SetAge(age);
    }

    public void SetId()
    {
        if (Id != null) {
            return;
        }
        Id = UUID.randomUUID().toString();
    }

    public String GetId()
    {
        return this.Id;
    }

    public void SetName(String name)
    {
        this.Name = name;
    }

    public String GetName()
    {
        return this.Name;
    }

    public void SetAge(int age)
    {
        this.Age = age;
    }

    public int GetAge()
    {
        return this.Age;
    }
}
