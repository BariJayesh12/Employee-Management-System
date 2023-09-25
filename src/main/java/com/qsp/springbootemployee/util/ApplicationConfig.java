package com.qsp.springbootemployee.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //http://localhost:8080/Swagger-ui.html#   link of swagger
public class ApplicationConfig {
	
	@Bean
	public Docket getDocket() {
		 Contact contact=new Contact("Q Spider", "https://qspider.com","qspider@gmail.com");
		 List<VendorExtension> list=new ArrayList<VendorExtension>();
		 ApiInfo apiInfo=new ApiInfo("EMPLOYEE MANAGEMENT", "USE TO MANAGE DETAILS OF THE EMPLOYEE ", "Version 1.2", "1 year of Service", contact, "www.ems.com","www.ems.com", list);
		
		 return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.
				 basePackage("com.qsp.springbootemployee")).build().
				 apiInfo(apiInfo).useDefaultResponseMessages(false);
	}

}
