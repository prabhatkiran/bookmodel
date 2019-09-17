package com.sap.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.book.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
	
	void deleteByBookId(int bookId);
	
	Book save(Book book);
	
	Book findByBookId(int bookId);

}
