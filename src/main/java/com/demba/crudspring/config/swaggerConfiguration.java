package com.demba.crudspring.config;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerConfiguration {
	

public Docket api(){
	return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(
					new ApiInfoBuilder()
					.description(" CRUD SPRING Api Docummentation ")
					.title("CRUD SPRING REST API")
					.build()
			)
			.groupName("REST API V1")
			.select() 
	 		.apis(RequestHandlerSelectors.basePackage("com.demba.crudspring"))
			.paths(PathSelectors.ant("crudspring/v1/**")).build();
	
 }
}
