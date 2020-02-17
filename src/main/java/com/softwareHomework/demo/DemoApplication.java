package com.softwareHomework.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.softwareHomework.controller", "com.softwareHomework.model", 
		"com.softwareHomework.repository", "com.softwareHomework.Impl"})

@EntityScan(basePackages = {"com.softwareHomework.model", "com.softwareHomework.repository"})
@EnableJpaRepositories(basePackages = {"com.softwareHomework.model", "com.softwareHomework.repository"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
