package com.munichwarriors.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ManageMunichWarriorsApp {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(ManageMunichWarriorsApp.class, args);

        // List all bean 	 in the application context
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
		
		//SpringApplication.run(ManageMunichWarriorsApp.class, args);
	}

}
