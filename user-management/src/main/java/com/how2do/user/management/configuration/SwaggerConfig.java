package com.how2do.user.management.configuration;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.PathSelectors.regex;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {
    @Value("${project.version}")
    private String version;
    @Value("${user.swagger.baseurl}")
    private String baseUrl;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public Docket swaggerPlugin(ServletContext servletContext) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/*.*"))
                .paths(not(regex("/error.*")))
                .build()
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return baseUrl;
                    }
                });
        docket.tags(new Tag("User Management", "Endpoints for user user management"));
        docket.useDefaultResponseMessages(false);
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User APIs")
                .description("API endpoints for user")
                .version(version)
                .build();
    }

}
