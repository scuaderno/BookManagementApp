package com.book.app.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.app.entity.Checkout;
import com.book.app.repository.CheckoutDao;
import com.book.app.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private static Logger logger = LoggerFactory.getLogger(CheckoutServiceImpl.class);
	
	@Autowired
	private CheckoutDao checkoutDao;
	
	@Override
	public List<Checkout> viewAllCheckedOutBooks() {
		return checkoutDao.findAll();
	}

	@Override
	public List<Checkout> viewReturnedBooks(String isReturned) throws Exception {
		isReturned = "Y";
		List<Checkout> returnedBooks = checkoutDao.findByIsReturned(isReturned);
		if(returnedBooks != null) {
			return returnedBooks;
		} else {
			logger.info("Book is not Yet Returned");
			throw new Exception();
		}
	}

	@Override
	public List<Checkout> viewNotReturnedBooks(String isReturned) throws Exception {
		isReturned = "N";
		List<Checkout> returnedBooks = checkoutDao.findByIsReturned(isReturned);
		if(returnedBooks != null) {
			return returnedBooks;
		} else {
			logger.info("Book was Returned");
			throw new Exception();
		}
	}

}
