package com.bs0842.accounts;

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
        title = "Account microservice API Documentation",
		description = "EasyBank Account Microservice REST API Documentation",
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
			description = "EasyBank Account Microservice REST API Documentation",
			url = "http://localhost:8080/swagger-ui/index.html#/"
	)
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
