package com.springhttpserver.Services;

import com.springhttpserver.DataAccess.UserProfileAccess;
import com.springhttpserver.Models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService implements IUserProfileService {
    private UserProfileAccess dataAccess;

    @Autowired
    public UserProfileService(UserProfileAccess userProfileAccess)
    {
        dataAccess = userProfileAccess;
    }

    public UserProfile GetUserProfile(String userId) {
        return dataAccess.GetUserProfile(userId);
    }

    @Override
    public void CreateNewUserProfile(UserProfile userProfile) {
        // validation checks?
        dataAccess.CreateUserProfile(userProfile);
    }

    @Override
    public void DeleteUserProfile(String userId) {
        dataAccess.RemoveUserProfile(userId);
    }
}
