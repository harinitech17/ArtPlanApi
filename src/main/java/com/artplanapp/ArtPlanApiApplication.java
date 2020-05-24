package com.artplanapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.artplanapp")
public class ArtPlanApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtPlanApiApplication.class, args);
	}

}
