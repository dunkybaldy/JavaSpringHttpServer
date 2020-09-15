package com.springhttpserver.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String Id; // GUID
    @NotBlank
    private String Name;
    @NotBlank
    private int Age;

    public UserProfile()
    {

    }

    public void SetId(String id) { this.Id = id; }

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
