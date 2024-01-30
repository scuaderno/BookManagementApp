package com.book.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.app.entity.Checkout;
import com.book.app.service.CheckoutService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CheckoutController {

	private static Logger logger = LoggerFactory.getLogger(CheckoutController.class);
	
	@Autowired
	private CheckoutService checkoutService;
	
	@GetMapping("/checkedoutBooks")
	public ResponseEntity<List<Checkout>> viewAllCheckedOutBooks() {
		
		List<Checkout> checkoutResponseList = new ArrayList<>();
		try {
			checkoutResponseList = checkoutService.viewAllCheckedOutBooks();
			return ResponseEntity.ok().body(checkoutResponseList);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/checkedout/returnStatus/{isReturned}")
	public ResponseEntity<List<Checkout>> viewReturnBookStatus(@PathVariable("isReturned") String isReturned) {
		
		List<Checkout> checkoutResponseList = new ArrayList<>();
		try {
			if(isReturned.contentEquals("Y")) {
				checkoutResponseList = checkoutService.viewReturnedBooks(isReturned);
			} else if(isReturned.contentEquals("N")) {
				checkoutResponseList = checkoutService.viewNotReturnedBooks(isReturned);
			}
			return ResponseEntity.ok().body(checkoutResponseList);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
}
