package org.example.shelf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import org.example.shelf.documentation.DocumentationConstants;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ApiObject(name = "Book", group = DocumentationConstants.GROUP_LIBRARY, description = "Represents a book. Every book has an <code>Author</code> and a price.")
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

	@Column(name = "price")
	@ApiObjectField(required = true, format = "Must be a double", description = "The price of the book")
	private Double price;
}
