package org.example.shelf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude = "id")
@ApiObject
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiObjectField(description = "The book's ID", order = 4)
	private Long id;

	@Column(name = "title")
	@ApiObjectField(description = "The book's title", order = 2)
	private String title;

	@ManyToOne
	@JoinColumn(name = "author_id")
	@ApiObjectField(description = "The book's author", order = 1)
	private Author author;

}
