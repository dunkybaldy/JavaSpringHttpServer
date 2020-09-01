package com.springhttpserver.Models.AppSettings;

import org.springframework.stereotype.Component;

@Component
public class DatabaseSettings {

    public String Endpoint;
    public int Port;
    public String DbName;
    public String Username;
    public String Password;

    public DatabaseSettings()
    {
        this.Endpoint = System.getProperty("aws_database.rds_endpoint");
        this.Port = Integer.parseInt(System.getProperty("aws_database.rds_port"));
        this.DbName = System.getProperty("aws_database.rds_name");
        this.Username = System.getProperty("aws_database.rds_username");
        this.Password = System.getProperty("aws_database.rds_password");
    }
}
