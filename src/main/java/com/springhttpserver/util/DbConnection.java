package com.springhttpserver.util;

import com.springhttpserver.Models.AppSettings.DatabaseSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbConnection {

    @Autowired
    private DatabaseSettings databaseSettings;
    private final String JdbcUrl;

    public DbConnection()
    {
        JdbcUrl = "jdbc:mysql://" + databaseSettings.Endpoint + ":" +
                databaseSettings.Port + "/" + databaseSettings.DbName + "?user=" + databaseSettings.Username + "&password=" + databaseSettings.Password;
    }

    public <T> List<T> PerformReadQuery(String query, Method mapper) {
        List<T> dbObjects = new ArrayList<T>();

        try {
            Class.forName(System.getProperty("jdbc.driver.mysql"));
            Connection con = DriverManager.getConnection(this.JdbcUrl);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
//                long id = rs.getLong("ID");
//                String name = rs.getString("FIRST_NAME");
//                String lastName = rs.getString("LAST_NAME");
                T obj = (T) mapper.invoke(null, rs);
                dbObjects.add(obj);
                // do something with the extracted data...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dbObjects;
    }

    public void PerformWriteQuery(String query)
    {

    }
}
