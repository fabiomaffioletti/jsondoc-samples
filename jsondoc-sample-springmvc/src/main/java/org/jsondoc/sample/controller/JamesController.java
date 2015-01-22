package org.jsondoc.sample.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(name = "james services", description = "This is a temporary controller to test that some bugs are fixed")
@Controller
@RequestMapping(value = "/james", produces = MediaType.APPLICATION_JSON_VALUE)
public class JamesController {

	@ApiMethod(responsestatuscode = "204", description = "This is to test that if you specify a response status code, that is the one displayed in the docs")
	@RequestMapping(value = "/overrideResponseStatusCode", method = RequestMethod.GET)
	public @ResponseBody @ApiResponseObject
	void nocontent() {
		
	}
	
	@ApiMethod(description = "This is to test that if you forget to put the @ApiResponseObject, then no error is thrown")
	@RequestMapping(value = "/missingApiResponseObject")
	public @ResponseBody String missingApiResponseObject() {
		return "ok";
	}
	
}
