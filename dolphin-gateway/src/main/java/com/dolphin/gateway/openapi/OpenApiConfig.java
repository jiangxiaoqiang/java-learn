package misc.config.openapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://springdoc.org/
 * https://github.com/springdoc/springdoc-openapi
 *
 * https://stackoverflow.com/questions/72485521/the-provided-definition-does-not-specify-a-valid-version-field-when-render-opena
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi fortuneApi() {
        GroupedOpenApi.Builder builder = GroupedOpenApi.builder()
                .pathsToMatch("/fortune/**")
                .group("dddd");
        GroupedOpenApi groupedOpenApi = builder.build();
        return groupedOpenApi;
    }

    @Bean
    public OpenAPI fortuneAPI() {
        return new OpenAPI()
                .info(new Info().title("Fortune API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

}
