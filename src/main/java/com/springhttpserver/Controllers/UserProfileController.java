package com.springhttpserver.Controllers;

import com.springhttpserver.Models.UserProfile;
import com.springhttpserver.Services.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserProfileController {
    private IUserProfileService _service;

    @Autowired
    public UserProfileController(IUserProfileService service) {
        _service = service;
    }

    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public UserProfile GetUserProfile(@PathVariable("userId") String userId)
    {
        try
        {
            return _service.GetUserProfile(userId);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserProfile> CreateNewUserProfile(@RequestBody UserProfile userProfile)
    {
        try
        {
            UserProfile newUserProfile = _service.CreateNewUserProfile(userProfile);
            return ResponseEntity.ok(newUserProfile);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity CreateNewUserProfile(@PathVariable("userId") String userId)
    {
        try
        {
            if (_service.DeleteUserProfile(userId) == false);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
