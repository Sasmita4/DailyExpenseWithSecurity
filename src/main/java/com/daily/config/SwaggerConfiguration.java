package com.daily.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RefreshScope
public class SwaggerConfiguration {
	
	@Value("${swagger.title}")
	private String title;
	
	@Value("${swagger.description}")
	private String description;
	
	@Value("${swagger.version}")
	private String version;
	
	@Value("${swagger.termsOfServiceUrl}")
	private String termsOfServiceUrl;
	
	@Value("${swagger.contact}")
	private String contact;
	
	@Value("${swagger.license}")
	private String license;
	
	@Value("${swagger.licenseUrl}")
	private String licenseUrl;
	
	@Bean  
    public Docket api() {  
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .genericModelSubstitutes(ResponseEntity.class)
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .paths(PathSelectors.any())
                .build();
    }  
	 private ApiInfo apiInfo() {  
         return new ApiInfo(title, description, version, termsOfServiceUrl, contact,license, licenseUrl);  
     }  
}
