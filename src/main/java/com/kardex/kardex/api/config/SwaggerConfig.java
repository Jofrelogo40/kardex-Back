package com.kardex.kardex.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        protocols.add("https");

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.protocols(protocols);

        docket.select()
                .apis(RequestHandlerSelectors.basePackage("com.kardex.kardex.api.api")).paths(PathSelectors.any()).build();

        docket.apiInfo(this.apiInfo());
        return docket;

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Kardex Api").version("1.0.0").build();
    }
}
