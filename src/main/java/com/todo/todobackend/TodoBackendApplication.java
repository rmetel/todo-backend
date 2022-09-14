package com.todo.todobackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(
		title = "ToDo Api",
		version = "1.0",
		description = "API for task administration",
		contact = @Contact(
			name = "Ralph Metel",
			email = "ralph.metel@exxeta.com"
		)
	)
)
public class TodoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoBackendApplication.class, args);
    }

	/*@Bean
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
	}*/

}
