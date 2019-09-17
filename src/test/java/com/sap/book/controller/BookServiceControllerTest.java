package com.sap.book.controller;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.sap.book.Application;
import com.sap.book.model.Book;
import com.sap.book.repository.BookRepository;
import com.sap.book.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class BookServiceControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepo;
	
	private List<Book> books;
	
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void getBooksTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/books").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2))).andDo(print());	
	}
	
	@Test
	public void getBookTest() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders.get("/books/45").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.bookId").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.isbn").exists());
	}
}
