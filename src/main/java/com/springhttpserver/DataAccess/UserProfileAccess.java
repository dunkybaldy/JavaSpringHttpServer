package com.springhttpserver.DataAccess;

import com.springhttpserver.Models.UserProfile;
import com.springhttpserver.Database.DbConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserProfileAccess implements IUserProfileAccess {
    @Autowired
    private DbConnectionPool DbConnectionPool;

    public UserProfileAccess() {}


    @Override
    public void CreateUserProfile(UserProfile userProfile) {

    }

    @Override
    public void RemoveUserProfile(String userId) {

    }

    @Override
    public UserProfile GetUserProfile(String userId) {
        return null;
    }

    @Override
    public Map<String, UserProfile> GetAllUserProfiles() {
        return null;
    }
}
