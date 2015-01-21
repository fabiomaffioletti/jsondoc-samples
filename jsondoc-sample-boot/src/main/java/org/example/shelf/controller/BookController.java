package org.example.shelf.controller;

import java.util.List;

import org.example.shelf.flow.ShelfFlowConstants;
import org.example.shelf.model.Book;
import org.example.shelf.repository.BookRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(description = "The books controller", name = "Books services")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@ApiMethod(id = ShelfFlowConstants.BOOK_FIND_ONE)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ApiResponseObject Book findOne(@ApiPathParam(name = "id") @PathVariable Long id) {
		return bookRepository.findOne(id);
	}
	
	@ApiMethod(id = ShelfFlowConstants.BOOK_FIND_ALL)
	@RequestMapping(method = RequestMethod.GET)
	public @ApiResponseObject List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	@ApiMethod(id = ShelfFlowConstants.BOOK_SAVE)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ApiResponseObject ResponseEntity<Void> save(@ApiBodyObject @RequestBody Book book, UriComponentsBuilder uriComponentsBuilder) {
		bookRepository.save(book);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(uriComponentsBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@ApiMethod(id = ShelfFlowConstants.BOOK_DELETE)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@ApiPathParam(name = "id") @PathVariable Long id) {
		Book book = bookRepository.findOne(id);
		bookRepository.delete(book);
	}

}
