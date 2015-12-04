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

import org.example.shelf.documentation.DocumentationConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Builder;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
@EqualsAndHashCode(of = "name")
@ApiObject(name = "Author", group = DocumentationConstants.GROUP_LIBRARY, description = "Represents an author. Every author has a list of <code>Book</code>s")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiObjectField
	private Long id;

	@Column(name = "name")
	@NotBlank
	@Length(min = 5, max = 20)
	@ApiObjectField(required = true, description = "Name and surname of the author")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ApiObjectField
	private List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		this.getBooks().add(book);
		book.setAuthor(this);
	}
	
}
