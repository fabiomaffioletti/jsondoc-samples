package org.jsondoc.sample.pojo;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject
public class Hint {

	@ApiObjectField
	private Integer id;
	@ApiObjectField
	private String username;
	@ApiObjectField(description = "The age of this object", required = true)
	private Integer age;
	@ApiObjectField(description = "The gender of this object", required = false)
	private String gender;

	public Hint() {

	}

	public Hint(Integer id, String username, Integer age, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
