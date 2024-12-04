package com.luandias.bookstore_jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luandias.bookstore_jpa.models.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID> {

	BookModel findBookModelByTitle(String title);

	@Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
	BookModel findBooksByPublisherId(@Param("id") UUID id);

}
