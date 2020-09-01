package com.springhttpserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void SetupMocks()
    {
//        HelloDataAccess da = mock(HelloDataAccess.class);
    }

    private String baseUrl() { return "http://localhost:" + port + "/"; }

    @Test
    public void HelloWorldTest()
    {
        String value = restTemplate.getForObject(
                baseUrl() + "hello",
                String.class);
        assertThat(value).isNotEmpty();
    }
}
