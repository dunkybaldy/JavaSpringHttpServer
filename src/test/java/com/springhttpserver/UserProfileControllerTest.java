package com.springhttpserver;

import com.springhttpserver.Models.UserProfile;
import com.springhttpserver.TestHelpers.ApiEndpointBuilder;
import com.springhttpserver.TestHelpers.Endpoints;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class UserProfileControllerTest {
    @Autowired
    private ApplicationContext applicationContext;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    public static void BeforeAll(){
//        DataSource con = applicationContext.getBean(DataSource.class);
//        con.
    }

    @Test
    public void UserNotFound() throws Exception {
        String userId = "Duncan";
        String getUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
            .Add(Endpoints.UPCGetUserProfile(userId))
            .Build();

        ResponseEntity<UserProfile> getResponse = this.restTemplate.getForEntity(getUserEndpoint, UserProfile.class);

        assertThat(getResponse.getStatusCode().is4xxClientError()).isTrue();
    }

    @Test
    public void CreateUser() {
        String name = "CreateAndGetUserTest";
        int age = 100;

        UserProfile up = new UserProfile(name, age);
        String createUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
                .Add(Endpoints.UPCCreateUserProfile())
                .Build();

        ResponseEntity<UserProfile> createResponse = this.restTemplate.postForEntity(createUserEndpoint, up, UserProfile.class);
        UserProfile userProfile = createResponse.getBody();
        assertThat(userProfile.getid()).isNotNull();
    }

    @Test
    public void UpdateUserSuccessfully() {
        String name = "UpdateUserTest";
        int age = 100;

        UserProfile userProfile = new UserProfile(name, age);
        String createUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
                .Add(Endpoints.UPCCreateUserProfile())
                .Build();

        ResponseEntity<UserProfile> postResponse = this.restTemplate.postForEntity(createUserEndpoint, userProfile, UserProfile.class);
        UserProfile postUser = postResponse.getBody();

        String newName = "Binky";
        String updateUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
                .Add(Endpoints.UPCUpdateUserProfile(postUser.getid()))
                .Build();

        postUser.setname(newName);
        this.restTemplate.put(updateUserEndpoint, postUser);

        String getUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
                .Add(Endpoints.UPCGetUserProfile(postUser.getid()))
                .Build();

        ResponseEntity<UserProfile> rResponse = this.restTemplate.getForEntity(getUserEndpoint, UserProfile.class);
        UserProfile y = rResponse.getBody();

        assertThat(y.getname()).isEqualTo(newName);
    }

    @Test
    public void CreateAndDeleteUser() {
        String name = "CreateAndDeleteUserTest";
        int age = 100;

        UserProfile up = new UserProfile(name, age);
        String createUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
                .Add(Endpoints.UPCCreateUserProfile())
                .Build();

        ResponseEntity<UserProfile> cResponse = this.restTemplate.postForEntity(createUserEndpoint, up, UserProfile.class);
        UserProfile x = cResponse.getBody();
        assertThat(x.getid()).isNotNull();
        String userId = x.getid();

        String deleteUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
                .Add(Endpoints.UPCDeleteUserProfile(userId))
                .Build();

        this.restTemplate.delete(deleteUserEndpoint);

        String getUserEndpoint = new ApiEndpointBuilder(Endpoints.BaseUrlLocalhost(this.port))
                .Add(Endpoints.UPCGetUserProfile(userId))
                .Build();

        ResponseEntity<UserProfile> gResponse = this.restTemplate.getForEntity(getUserEndpoint, UserProfile.class);

        assertThat(gResponse.getStatusCode().is4xxClientError()).isTrue();
    }
}
