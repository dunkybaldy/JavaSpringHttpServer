package com.springhttpserver.DataAccess;

import com.springhttpserver.Models.UserProfile;

import java.util.Map;

public interface IUserProfileAccess {
    void CreateUserProfile(UserProfile userProfile);
    void RemoveUserProfile(String userId);
    UserProfile GetUserProfile(String userId);
    Map<String, UserProfile> GetAllUserProfiles();
}
