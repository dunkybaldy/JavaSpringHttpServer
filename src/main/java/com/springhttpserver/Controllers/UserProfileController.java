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
    @Autowired
    private IUserProfileService _service;

    public UserProfileController() {
    }

    @GetMapping(value = "/get/{userId}", produces = "application/json")
    public ResponseEntity<UserProfile> GetUserProfile(@PathVariable("userId") String userId)
    {
        try
        {
            return ResponseEntity.ok(_service.GetUserProfile(userId));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/create",consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserProfile> CreateNewUserProfile(@RequestBody UserProfile userProfile)
    {
        try
        {
            UserProfile newUserProfile = _service.CreateNewUserProfile(userProfile);
            return ResponseEntity.ok(newUserProfile);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping(value = "/update/{userId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserProfile> UpdateUserProfile(@PathVariable("userId") String userId, @RequestBody UserProfile userProfile)
    {
        try
        {
            UserProfile newUserProfile = _service.UpdateUserProfile(userId, userProfile);
            return ResponseEntity.ok(newUserProfile);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity CreateNewUserProfile(@PathVariable("userId") String userId)
    {
        try
        {
            _service.DeleteUserProfile(userId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.notFound().build();
        }

    }
}
