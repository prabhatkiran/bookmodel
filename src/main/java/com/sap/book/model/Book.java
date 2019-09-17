package com.sap.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name="Book")

public class Book extends ResourceSupport {
	
	@Id
	@Column(name="bookId")
    private int bookId;
	@Column(name="isbn")
	private String isbn;
	@Column(name="name")
	private String name;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Book() {
    }

    public Book(int bookId, String name, String isbn) {
        this.bookId = bookId;
        this.name = name;
        this.isbn = isbn;
    }
}
