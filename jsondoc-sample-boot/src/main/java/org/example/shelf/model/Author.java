package org.example.shelf.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "books")
@EqualsAndHashCode(of = "name")
@ApiObject
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiObjectField
	private Long id;

	@Column(name = "name")
	@ApiObjectField
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ApiObjectField
	private List<Book> books = new ArrayList<Book>();
	
}
