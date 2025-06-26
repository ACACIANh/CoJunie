package kr.universe.cojunie.swagger.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Configuration for OpenAPI documentation
 */
@Configuration
class OpenApiConfig {
    @Value("\${spring.application.name:CoJunie}")
    private lateinit var applicationName: String

    /**
     * Configure OpenAPI documentation
     * @return The OpenAPI configuration
     */
    @Bean
    fun openAPI(): OpenAPI {
        val securitySchemeName = "bearerAuth"

        return OpenAPI()
            .info(apiInfo())
            .addSecurityItem(SecurityRequirement().addList(securitySchemeName))
            .components(
                Components()
                    .addSecuritySchemes(
                        securitySchemeName,
                        SecurityScheme()
                            .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT"),
                    ),
            )
    }

    /**
     * Configure API information
     * @return The API information
     */
    private fun apiInfo(): Info {
        return Info()
            .title("$applicationName API")
            .description("API documentation for $applicationName")
            .version("1.0.0")
            .contact(
                Contact()
                    .name("CoJunie Team")
                    .email("contact@cojunie.kr")
                    .url("https://cojunie.kr"),
            )
            .license(
                License()
                    .name("Apache 2.0")
                    .url("https://www.apache.org/licenses/LICENSE-2.0.html"),
            )
    }
}
