package com.todo.todobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableSwagger2
public class TodoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoBackendApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.build()
				.apiInfo(new ApiInfo(
						"ToDo Api",
						"API for todo task administration",
						"1.0",
						"free to use",
						new Contact("Ralph Metel", "https://github.com/rmetel", "ralph.metel@exxeta.com"),
						"free to use",
						"free to use",
						Collections.emptyList()
				));
	}

}
