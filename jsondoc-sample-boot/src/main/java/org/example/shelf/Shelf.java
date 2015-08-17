package org.example.shelf;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJSONDoc
public class Shelf {
	
	public static void main(String[] args) {
		SpringApplication.run(Shelf.class, args);
	}

}
