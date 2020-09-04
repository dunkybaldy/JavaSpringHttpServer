package com.springhttpserver;

import com.springhttpserver.Controllers.UserProfileController;
import com.springhttpserver.Services.IUserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringHttpServerApplicationTests {
	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads()
	{
		UserProfileController userProfileController = context.getBean(UserProfileController.class);
		assertThat(userProfileController).isNotNull();
		assertThat(context.isSingleton("userProfileController")).isTrue();

		IUserProfileService helloService = context.getBean(IUserProfileService.class);
		assertThat(helloService).isNotNull();
		assertThat(context.isSingleton("helloService")).isTrue();
	}

}
