package com.sap.book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sap.book.model.Book;
import com.sap.book.repository.BookRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sap.book"})
public class Application {
	public static void main(String[] args) {
	      SpringApplication.run(Application.class, args);
	   }
	@Bean
	public CommandLineRunner setup (BookRepository bookRepo) {
		return (args) -> {
			bookRepo.save(new Book(45,"My best book 3","45"));
			bookRepo.save(new Book(46,"My best book 4","46"));
			
			
		};
	}
}
