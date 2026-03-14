package com.eazybytes.accounts;

import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.ControllerAdvice;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountsAuditImpl")
@OpenAPIDefinition(
        info= @Info(
                title = "Accounts Microservice REST API Doc",
                description = "Eazy Bank Accouts microservices REST API Doc",
                contact = @Contact(
                        name = "Akash",
                        email = "akash.s.2106@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0"
                )

        ),
        externalDocs = @ExternalDocumentation(
                description = "Eazy Bank Accounts microservices REST API Documentation",
                url = ""
        )
)
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
public class AccountsApplication {

	public static void main(String[] args) {

        SpringApplication.run(AccountsApplication.class, args);
	}

}
