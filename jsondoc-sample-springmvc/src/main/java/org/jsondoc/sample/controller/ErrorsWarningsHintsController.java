package org.jsondoc.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsondoc.sample.pojo.Hint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hint")
public class ErrorsWarningsHintsController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	String string(@PathVariable Integer id) {
		return "jsondoc error test";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Hint hint(@PathVariable("id") Integer id) {
		return new Hint();
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Hint> hints(@PathVariable("id") Integer id) {
		return new ArrayList<Hint>();
	}
	
}
