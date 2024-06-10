package io.shey.auth.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Moon API 文档",
        version = "1.0",
        description = "Moon API 文档",
        contact = @io.swagger.v3.oas.annotations.info.Contact(
                name = "Shey",
                email = "z_shey@163.com"
        )
))
public class OpenApiConfig {
}