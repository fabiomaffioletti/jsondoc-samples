package org.example.shelf;

import org.example.shelf.model.Author;
import org.example.shelf.model.Book;
import org.example.shelf.model.User;
import org.example.shelf.repository.AuthorRepository;
import org.example.shelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

@Configuration
public class DatabasePopulator implements CommandLineRunner {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void run(String... arg0) throws Exception {
		
		Author hornby = Author.builder().name("Nick Horby").books(Lists.<Book>newArrayList()).build();
		hornby.addBook(Book.builder().title("High fidelty").price(5.99D).build());
		hornby.addBook(Book.builder().title("A long way down").price(0.99D).build());
		Author smith = Author.builder().name("Wilbur Smith").books(Lists.<Book>newArrayList()).build();
		smith.addBook(Book.builder().title("Desert god").price(1.99D).build());
		authorRepository.save(hornby);
		authorRepository.save(smith);
		
		userRepository.save(User.builder().username("user-one").build());
		userRepository.save(User.builder().username("user-two").build());
		userRepository.save(User.builder().username("user-three").build());
		
	}

}
