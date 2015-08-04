package org.jsondoc.sample.controller;

import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.sample.data.SampleData;
import org.jsondoc.sample.flow.FlowConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sample.external.pojo.Author;
import com.sample.external.pojo.Book;

@Api(name = "book services", description = "Books services")
@Controller
@RequestMapping(value = "/books")
public class BookController {

	@ApiMethod(id = FlowConstants.BOOK_LIST_METHOD_ID, summary = "Gets a list of books")
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody @ApiResponseObject
	List<Book> books() {
		return SampleData.books;
	}
	
	@ApiMethod(id = FlowConstants.BOOK_OBJECT_METHOD_ID)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody @ApiResponseObject
	Book book(@ApiPathParam @PathVariable("id") Integer id) {
		for (Book book : SampleData.books) {
			if(book.getId() == id) {
				return book;
			}
		}
		
		return new Book(id, "A random title", new Author(99, "A random name", "A random surname"));
	}
	
	@ApiMethod(id = FlowConstants.BOOK_PURCHASE_METHOD_ID)
	@RequestMapping(value = "/purchase/{id}", method = { RequestMethod.POST, RequestMethod.PUT })
	@ResponseStatus(value = HttpStatus.CREATED)
	public void purchase(@ApiPathParam @PathVariable("id") Integer id) {
		
	}
	
	@ApiMethod(id = FlowConstants.BOOK_SIMILAR_METHOD_ID)
	@RequestMapping(value = "/similar/{id}", method = RequestMethod.GET)
	public @ResponseBody @ApiResponseObject
	List<Book> similar(@ApiPathParam @PathVariable("id") Integer id) {
		return SampleData.books;
	}
	
}
