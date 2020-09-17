package com.springhttpserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@SpringBootApplication
public class SpringHttpServerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringHttpServerApplication.class);
//		app.setApplicationContextClass(context);
//		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));

		app.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
}
