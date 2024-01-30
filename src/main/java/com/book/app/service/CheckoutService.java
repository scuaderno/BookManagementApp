package com.book.app.service;

import java.util.List;

import com.book.app.entity.Checkout;

public interface CheckoutService {

	public List<Checkout> viewAllCheckedOutBooks();
	public List<Checkout> viewReturnedBooks(String isReturned) throws Exception;
	public List<Checkout> viewNotReturnedBooks(String isReturned) throws Exception;
}
