package com.example.museumApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class MuseumAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseumAppApplication.class, args);

		//testing pushing change to github

		System.out.println();
	}

}
