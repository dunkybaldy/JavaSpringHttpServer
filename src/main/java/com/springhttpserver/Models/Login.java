package com.springhttpserver.Models;

public class Login {
    private String Username;
    private String Password;

    public Login(String username, String password)
    {
        this.Username = username;
        this.Password = password;
    }

    public String GetUsername()
    {
        return this.Username;
    }

    public String GetPassword()
    {
        return this.Password;
    }
}
