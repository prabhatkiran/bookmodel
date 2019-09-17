package com.sap.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.sap.book.service.*;

import com.sap.book.model.Book;

@RestController
public class BookServiceController {
	
	@Autowired
	BookService bookService;
	
	@CrossOrigin("http://localhost:3000")
	@GetMapping(value = "/books")
	public List getBooks() {
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(book -> {
			book.add(linkTo(methodOn(BookServiceController.class)
		         .getBook(book.getBookId()))
		         .withSelfRel());
		  });
		return allBooks;
	}
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
		Book singleBook =  bookService.getBook(id);
		singleBook.add(linkTo(methodOn(BookServiceController.class)
		          .updateBooks(singleBook.getBookId(),singleBook))
		          .withRel("Update"));
		singleBook.add(linkTo(methodOn(BookServiceController.class)
		          .delete(singleBook.getBookId()))
		          .withRel("Delete"));
        return singleBook;
    }
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<Object> createBooks(@RequestBody Book postedBook) {
		bookService.addBook(postedBook);
	    return new ResponseEntity<Object>("A new book is added to the inventory", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateBooks(@PathVariable("id") int id, @RequestBody Book updatedBook){
		bookService.updateBook(id, updatedBook);
		return new ResponseEntity<Object>("The book with ID"+" "+id+" "+"is updated successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public Book delete(@PathVariable("id") int id) { 
		return bookService.deleteBook(id);
		}
}
