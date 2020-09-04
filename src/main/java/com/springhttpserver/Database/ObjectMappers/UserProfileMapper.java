package com.springhttpserver.Database.ObjectMappers;

import com.springhttpserver.Models.UserProfile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileMapper implements RowMapper<UserProfile> {
    @Override
    public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        String name = rs.getString("NAME");
        int age = rs.getInt("AGE");

        UserProfile userProfile = new UserProfile(name, age);

        return userProfile;
    }
}
