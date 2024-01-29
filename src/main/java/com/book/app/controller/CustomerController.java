package com.book.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.app.entity.Customer;
import com.book.app.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerController {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/listOfCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		
		List<Customer> customerResponseList = new ArrayList<>();
		try {
			customerResponseList = customerService.getAllCustomers();
			return ResponseEntity.ok().body(customerResponseList);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) {
		Customer customerResponse = new Customer();
		try {
			customerResponse = customerService.getCustomerById(customerId);
			return ResponseEntity.ok().body(customerResponse);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/customer/newCustomer")
	public ResponseEntity<Customer> createCustomer(Customer customer) {
		Customer customerResponse = new Customer();
		try {
			customerResponse = customerService.saveCustomer(customer);
			return ResponseEntity.ok().body(customerResponse);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value="/customer/update/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId) {
		Customer customerResponse = new Customer();
		try {
			customerResponse = customerService.modifyCustomer(customerId);
			return ResponseEntity.ok().body(customerResponse);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping(value="/customer/delete/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") int customerId) {
		Customer customerResponse = new Customer();
		try {
			customerResponse = customerService.deleteCustomer(customerId);
			return ResponseEntity.ok().body(customerResponse);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

}
