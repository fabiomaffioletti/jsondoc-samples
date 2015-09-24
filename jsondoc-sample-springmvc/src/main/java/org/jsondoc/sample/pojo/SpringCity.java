package org.jsondoc.sample.pojo;

public class SpringCity extends SpringLocation {

	private String name;

	public SpringCity() {

	}

	public SpringCity(String name, Integer population, Integer squarekm) {
		super(population, squarekm);
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
