package com.springhttpserver.Services;

import com.springhttpserver.Models.UserProfile;

public interface IUserProfileService {
    UserProfile GetUserProfile(String userId);
    UserProfile CreateNewUserProfile(UserProfile userProfile);
    UserProfile UpdateUserProfile(String userId, UserProfile userProfile);
    void DeleteUserProfile(String userId);
}
