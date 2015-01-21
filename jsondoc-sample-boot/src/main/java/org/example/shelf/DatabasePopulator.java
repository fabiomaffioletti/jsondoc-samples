package org.example.shelf;

import org.example.shelf.model.Author;
import org.example.shelf.model.Book;
import org.example.shelf.repository.AuthorRepository;
import org.example.shelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabasePopulator implements CommandLineRunner {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public void run(String... arg0) throws Exception {
		Author horbny = new Author();
		horbny.setId(1L);
		horbny.setName("Nick Horby");
		
		Author smith = new Author();
		smith.setId(2L);
		smith.setName("Wilbur Smith");
		
		authorRepository.save(horbny);
		authorRepository.save(smith);
		
		Book highFidelty = new Book();
		highFidelty.setId(1L);
		highFidelty.setTitle("High fidelty");
		highFidelty.setAuthor(horbny);
		
		Book aLongWayDown = new Book();
		aLongWayDown.setId(2L);
		aLongWayDown.setTitle("A long way down");
		aLongWayDown.setAuthor(horbny);

		Book desertGod = new Book();
		desertGod.setId(3L);
		desertGod.setTitle("Desert god");
		desertGod.setAuthor(smith);
		
		bookRepository.save(highFidelty);
		bookRepository.save(aLongWayDown);
		bookRepository.save(desertGod);
	}

}
