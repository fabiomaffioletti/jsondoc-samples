package org.jsondoc.sample.pojo;

public abstract class SpringLocation {

	private Integer population;

	private Integer squarekm;

	public SpringLocation() {

	}

	public SpringLocation(Integer population, Integer squarekm) {
		super();
		this.population = population;
		this.squarekm = squarekm;
	}

	public Integer getPopulation() {
		return population;
	}

	public Integer getSquarekm() {
		return squarekm;
	}

}
