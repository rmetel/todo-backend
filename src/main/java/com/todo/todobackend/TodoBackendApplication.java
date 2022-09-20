package com.todo.todobackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
@OpenAPIDefinition(info = @Info(
	title = "ToDo Api",
	version = "1.0",
	description = "API for task administration",
	contact = @Contact(
		name = "Ralph Metel",
		email = "ralph.metel@exxeta.com"
	)
))
public class TodoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoBackendApplication.class, args);
	}
}
