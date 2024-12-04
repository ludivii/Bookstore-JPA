package com.luandias.bookstore_jpa.servicies;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luandias.bookstore_jpa.dtos.BookRecordDTO;
import com.luandias.bookstore_jpa.models.BookModel;
import com.luandias.bookstore_jpa.models.ReviewModel;
import com.luandias.bookstore_jpa.repositories.AuthorRepository;
import com.luandias.bookstore_jpa.repositories.BookRepository;
import com.luandias.bookstore_jpa.repositories.PublisherRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final PublisherRepository publisherRepository;

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
	}

	@Transactional
	public BookModel saveBook(BookRecordDTO bookRecordDTO) {
		BookModel book = new BookModel();
		book.setTitle(bookRecordDTO.title());
		book.setPublisher(publisherRepository.findById(bookRecordDTO.publisherId()).get());
		book.setAuthors(authorRepository.findAllById(bookRecordDTO.authorIds()).stream().collect(Collectors.toSet()));

		ReviewModel reviewModel = new ReviewModel();
		reviewModel.setComment(bookRecordDTO.reviewComment());
		reviewModel.setBook(book);
		book.setReview(reviewModel);

		return bookRepository.save(book);
	}
	
	public List<BookModel> getAllBooks(){
		return bookRepository.findAll();
	}

}
