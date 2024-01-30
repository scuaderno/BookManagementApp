package com.book.app.service;

import java.util.List;

import com.book.app.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public Book saveBook(Book customer);
	public Book getBookById(int customerId);
	public void deleteBook(int customerId);
	public Book modifyBook(int customerId);
}
