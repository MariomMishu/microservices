package com.bs0842.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(
        title = "Card microservice API Documentation",
		description = "EasyBank Card Microservice REST API Documentation",
        version = "v1",
		contact = @Contact(
				name = "Mariam Mishu",
				email = "mishu@yopmail.com",
				url = "https://www.linkedin.com/in/mariam-mishu/"
		),
		license = @License(
				name = "Apache 2.0",
				url = "http://www.eazybank.com"
		)
	),
	externalDocs = @ExternalDocumentation(
			description = "EasyBank Cards Microservice REST API Documentation",
			url = "http://localhost:8090/swagger-ui/index.html#/"
	)
)
public class CardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }

}
