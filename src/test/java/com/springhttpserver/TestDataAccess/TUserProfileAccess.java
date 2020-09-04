package com.springhttpserver.TestDataAccess;

import com.springhttpserver.DataAccess.IUserProfileAccess;
import com.springhttpserver.Models.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class TUserProfileAccess implements IUserProfileAccess {

    public Map<String, UserProfile> database;

    public TUserProfileAccess() {
        database = new HashMap<String, UserProfile>();
    }

    @Override
    public void AddData(UserProfile userProfile) {
        database.put(userProfile.GetName(), userProfile);
    }

    @Override
    public void RemoveData(String Name) {
        database.remove(Name);
    }

    @Override
    public UserProfile GetData(String Name) {
        return database.get(Name);
    }

    @Override
    public Map<String, UserProfile> GetAllData() {
        return database;
    }
}
