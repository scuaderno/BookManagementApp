package com.book.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.app.entity.Book;
import com.book.app.repository.BookDao;
import com.book.app.service.BookService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		return bookDao.save(book);
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDao.findById(bookId)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public void deleteBook(int bookId) {
		Optional<Book> book = bookDao.findById(bookId);
		if(book.isPresent()) {
			bookDao.delete(book.get());
		} else {
			logger.info("Failed to delete book id: {}" + bookId);
			throw new EntityNotFoundException();
		}
		
	}

	@Override
	public Book modifyBook(int bookId) {
		Optional<Book> book = bookDao.findById(bookId);
		if(book.isPresent()) {
			Book bookDetails = new Book();
			bookDetails.setAuthor(book.get().getAuthor());
			bookDetails.setBook_price(book.get().getBook_price());
			bookDetails.setBook_title(book.get().getBook_title());
			bookDetails.setCategory(book.get().getCategory());
			bookDetails.setQuantity(book.get().getQuantity());
			bookDetails.setYear_published(book.get().getYear_published());
			return saveBook(bookDetails);
		} else {
			logger.info("No Record Found for book id: {}" + bookId);
			throw new EntityNotFoundException();
		}
	}

}
