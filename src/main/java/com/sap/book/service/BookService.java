package com.sap.book.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.sap.book.model.Book;
import com.sap.book.repository.*;

@Service
@Transactional
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public List getAllBooks() {
        List books = new ArrayList();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
	public void addBook(Book addedBook) {
        bookRepository.save(addedBook);
    }

    public void updateBook(int id, Book updatedBook) {
        bookRepository.save(updatedBook);
    }
    public Book deleteBook(int id) {
    	bookRepository.deleteByBookId(id);
    	Book deletedBook = (Book) bookRepository.findByBookId(id);
    	return deletedBook;
    }
    public Book getBook(int id) {
    	Book singleBook = (Book) bookRepository.findByBookId(id);
    	return singleBook;
    }
}
