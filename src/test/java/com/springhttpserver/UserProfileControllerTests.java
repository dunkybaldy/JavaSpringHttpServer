package com.springhttpserver;

import com.springhttpserver.Models.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

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
//        UserProfileAccess da = mock(UserProfileAccess.class);
    }

    private String baseUrl() { return "http://localhost:" + port + "/"; }
    private String

    @Test
    public void CreateNewUserTest()
    {
        UserProfile up = GetExampleUserProfile();
        restTemplate.postForEntity()
    }

    public UserProfile GetExampleUserProfile()
    {
        return new UserProfile("Donk", 31);
    }
}
