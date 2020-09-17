package com.springhttpserver.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class UserProfile {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id; // GUID
    @NotBlank
    private String name;
    @NotBlank
    private int age;

    public UserProfile()
    {

    }

    public UserProfile(String name, int age)
    {
        setname(name);
        setage(age);
    }

    // setter getter names required: setvariableName ... getvariableName
    public void setid(String id) { this.id = id; }

    public String getid()
    {
        return this.id;
    }

    public void setname(String name)
    {
        this.name = name;
    }

    public String getname()
    {
        return this.name;
    }

    public void setage(int age)
    {
        this.age = age;
    }

    public int getage()
    {
        return this.age;
    }
}
