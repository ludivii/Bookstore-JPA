package com.luandias.bookstore_jpa.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_book")
public class BookModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(36)", length = 36)
	private UUID id;

	@Column(nullable = false, unique = true)
	private String title;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private PublisherModel publisher;

	@ManyToMany
	@JoinTable(name = "tb_book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<AuthorModel> authors = new HashSet<>();

	@OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
	private ReviewModel review;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PublisherModel getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherModel publisher) {
		this.publisher = publisher;
	}

	public Set<AuthorModel> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorModel> authors) {
		this.authors = authors;
	}

	public ReviewModel getReview() {
		return review;
	}

	public void setReview(ReviewModel review) {
		this.review = review;
	}

}
