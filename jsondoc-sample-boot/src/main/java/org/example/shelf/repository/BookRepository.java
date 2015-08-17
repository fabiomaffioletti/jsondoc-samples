package org.example.shelf.repository;

import org.example.shelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	void deleteByIdGreaterThan(Long id);

}
