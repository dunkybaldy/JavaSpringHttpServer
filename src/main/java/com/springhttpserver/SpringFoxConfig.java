package com.springhttpserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SpringFoxConfig {
        @Bean
        public Docket SwaggerAPI() {
                return new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.any())
                        .paths(PathSelectors.any())
                        .build()
//                        .securitySchemes(Arrays.asList(securityScheme()))
//                        .securityContexts(Arrays.asList(securityContext()))
                        .apiInfo(GetApiInfo());
        }

        private ApiInfo GetApiInfo()
        {
                return new ApiInfo(
                        "Contact Application API",
                        "This is a sample Spring Boot RESTful service using SpringFox + Swagger 2",
                        "V1",
                        "urn:tos",
                        new Contact("Duncan", "https://github.com/dunkybaldy", "baldwin27@protonmail.com"),
                        "CC BY-SA 3.0",
                        "https://creativecommons.org/licenses/by-sa/3.0/",
                        Collections.emptyList()
                );
        }
}
