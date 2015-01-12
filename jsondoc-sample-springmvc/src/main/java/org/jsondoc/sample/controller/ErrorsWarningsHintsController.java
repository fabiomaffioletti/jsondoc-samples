package org.jsondoc.sample.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(name = "errors warnings hints", description = "Methods for testing errors warnings and hints")
@Controller
@RequestMapping
public class ErrorsWarningsHintsController {

	@ApiMethod
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody @ApiResponseObject
	String string(@PathVariable @ApiPathParam Integer id) {
		return "jsondoc error test";
	}

}
