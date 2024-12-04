package com.luandias.bookstore_jpa.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_author")
public class AuthorModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(36)", length = 36)
	private UUID id;

	@Column(nullable = false, unique = true)
	private String name;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
	private Set<BookModel> books = new HashSet<>();
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BookModel> getBooks() {
		return books;
	}

	public void setBooks(Set<BookModel> books) {
		this.books = books;
	}

}
