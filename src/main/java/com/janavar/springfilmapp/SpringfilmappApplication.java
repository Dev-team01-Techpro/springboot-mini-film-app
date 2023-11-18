package com.janavar.springfilmapp;

import com.janavar.springfilmapp.domain.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringfilmappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringfilmappApplication.class, args);
		Film film = new Film();
	}

}
