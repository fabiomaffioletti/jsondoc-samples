package org.example.shelf;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories
@EnableJSONDoc
@ComponentScan
public class Shelf {
	
	public static void main(String[] args) {
		SpringApplication.run(Shelf.class, args);
	}

}
