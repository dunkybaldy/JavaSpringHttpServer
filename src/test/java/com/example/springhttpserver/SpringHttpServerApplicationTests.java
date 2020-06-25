package com.example.springhttpserver;

import com.example.springhttpserver.Controllers.HelloController;
import com.example.springhttpserver.Services.IHelloService;
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
		HelloController helloController = context.getBean(HelloController.class);
		assertThat(helloController).isNotNull();
		assertThat(context.isSingleton("helloController")).isTrue();

		IHelloService helloService = context.getBean(IHelloService.class);
		assertThat(helloService).isNotNull();
		assertThat(context.isSingleton("helloService")).isTrue();
	}

}
