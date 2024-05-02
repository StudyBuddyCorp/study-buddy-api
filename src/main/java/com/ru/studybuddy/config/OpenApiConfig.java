package com.ru.studybuddy.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "study-buddy-api",
                description = "Best api for best website writed by papla ak Pavel and woodemai ak Kolya. " +
                        "Use eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWRpbkByZWRpbi5yZWRpbiIsImlhdCI6MTcxNDYwNjQxNCwiZXhwIjoxNzE1OTAyNDE0fQ.Sq01H9117_VqsYZKDOgn1q9BzJ2MSjXKGb8dw5g8XgM for authorize token", version = "0.0.1",
                contact = @Contact(
                        name = "Kolya Savchenko",
                        email = "papla2016@yandex.ru",
                        url = "https://portfolio-woodemai.vercel.app/"
                )
        )
)
@SecurityScheme(
        name = "JWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {
}
