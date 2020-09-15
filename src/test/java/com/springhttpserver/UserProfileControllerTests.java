package com.springhttpserver;

import com.springhttpserver.Models.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserProfileControllerTests
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void SetupMocks()
    {
//        UserProfileDataAccess da = mock(UserProfileDataAccess.class);
    }

    private String baseUrl() { return "http://localhost:" + port + "/"; }
    private String GetUserProfileUrl(String userId) { return baseUrl() + "get/" + userId; }
    private String CreateUserProfileUrl() { return baseUrl() + "create"; }
    private String DeleteUserProfileUrl(String userId) { return baseUrl() + "delete/" + userId; }

    @Test
    public void CreateNewUserTest()
    {
//        UserProfile up = GetExampleUserProfile();
//        ResponseEntity re = restTemplate.postForEntity(CreateUserProfileUrl(), up, UserProfile.class);
    }
}
