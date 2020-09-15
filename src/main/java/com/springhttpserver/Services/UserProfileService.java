package com.springhttpserver.Services;

import com.springhttpserver.Database.DataAccess.IUserRepository;
import com.springhttpserver.Models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserProfileService implements IUserProfileService {
    @Autowired
    private IUserRepository userRepository;

    public UserProfileService()
    {

    }

    public UserProfile GetUserProfile(String userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public UserProfile CreateNewUserProfile(UserProfile userProfile) {
        // validation checks?
        UserProfile up = userRepository.save(userProfile);

        return GetUserProfile(up.GetId());
    }

    @Override
    public UserProfile UpdateUserProfile(String userId, UserProfile userProfile) {
        // validation checks?
        UserProfile user = GetUserProfile(userId);
        if (user.equals(userProfile))
        {
            return user;
        }
        user = userProfile;
        UserProfile up2 = userRepository.save(user);

        return GetUserProfile(up2.GetId());
    }

    @Override
    public void DeleteUserProfile(String userId) {
        userRepository.deleteById(userId);
    }
}
