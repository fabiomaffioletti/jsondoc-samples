package org.jsondoc.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsondoc.sample.pojo.SpringCity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/spring/cities")
public class SpringCityController {

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public @ResponseBody
	SpringCity get(@PathVariable("name") String name) {
		return new SpringCity(name, 1982700, 52);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody
	SpringCity post(@RequestBody SpringCity SpringCity) {
		return SpringCity;
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void delete(@PathVariable("id") Integer id) {

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody
	SpringCity getById(@PathVariable("id") Integer id) {
		return new SpringCity("SpringCityById", 1982700, 52);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	SpringCity put(@PathVariable("id") Integer id, @RequestBody SpringCity SpringCity) {
		return SpringCity;
	}

	@RequestMapping(value = "/map", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public 
	@ResponseBody
	Map<String, SpringCity> map() {
		Map<String, SpringCity> cities = new HashMap<String, SpringCity>();
		cities.put("a", new SpringCity("Adelaide", 4322, 8));
		cities.put("m", new SpringCity("Melbourne", 9080, 12));
		cities.put("p", new SpringCity("Perth", 743534, 5));
		cities.put("s", new SpringCity("Sydney", 54654, 32));
		return cities;
	}
	
	@RequestMapping(value = "/map/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public
	@ResponseBody
	Map<List<String>, SpringCity> mapList() {
		Map<List<String>, SpringCity> cities = new HashMap<List<String>, SpringCity>();
		List<String> a = new ArrayList<String>();
		a.add("a1");
		a.add("a2");
		List<String> m = new ArrayList<String>();
		m.add("m1");
		List<String> p = new ArrayList<String>();
		p.add("p1");
		List<String> s = new ArrayList<String>();
		s.add("s1");
		s.add("s2");
		s.add("s3");
		cities.put(a, new SpringCity("Adelaide", 4322, 8));
		cities.put(m, new SpringCity("Melbourne", 9080, 12));
		cities.put(p, new SpringCity("Perth", 743534, 5));
		cities.put(s, new SpringCity("Sydney", 54654, 32));
		return cities;
	}
	
}
