package com.book.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.app.entity.Book;
import com.book.app.service.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {

	private static Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/listOfBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		
		List<Book> bookResponseList = new ArrayList<>();
		try {
			bookResponseList = bookService.getAllBooks();
			return ResponseEntity.ok().body(bookResponseList);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") int bookId) {
		Book bookResponse = new Book();
		try {
			bookResponse = bookService.getBookById(bookId);
			return ResponseEntity.ok().body(bookResponse);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/book/newBook")
	public ResponseEntity<Book> createBook(@Valid Book book) {
		Book bookResponse = new Book();
		try {
			bookResponse = bookService.saveBook(book);
			return ResponseEntity.ok().body(bookResponse);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value="/book/update/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookId) {
		Book bookResponse = new Book();
		try {
			bookResponse = bookService.modifyBook(bookId);
			return ResponseEntity.ok().body(bookResponse);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping(value="/book/delete/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			bookService.deleteBook(bookId);
			logger.info("Successfully deleted book id: {}" + bookId);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
}
