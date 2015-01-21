package org.example.shelf.controller;

import java.util.List;

import org.example.shelf.flow.ShelfFlowConstants;
import org.example.shelf.model.Author;
import org.example.shelf.repository.AuthorRepository;
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
@RequestMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(description = "The author services", name = "Author services")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;

	@ApiMethod(id = ShelfFlowConstants.AUTHOR_FIND_ONE)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ApiResponseObject Author findOne(@ApiPathParam(name = "id") @PathVariable Long id) {
		return authorRepository.findOne(id);
	}

	@ApiMethod(id = ShelfFlowConstants.AUTHOR_FIND_ALL)
	@RequestMapping(method = RequestMethod.GET)
	public @ApiResponseObject List<Author> findAll() {
		return authorRepository.findAll();
	}

	@ApiMethod(id = ShelfFlowConstants.AUTHOR_SAVE)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ApiResponseObject ResponseEntity<Void> save(@ApiBodyObject @RequestBody Author author, UriComponentsBuilder uriComponentsBuilder) {
		authorRepository.save(author);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(uriComponentsBuilder.path("/authors/{id}").buildAndExpand(author.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@ApiMethod(id = ShelfFlowConstants.AUTHOR_DELETE)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@ApiPathParam(name = "id") @PathVariable Long id) {
		Author author = authorRepository.findOne(id);
		authorRepository.delete(author);
	}

}
