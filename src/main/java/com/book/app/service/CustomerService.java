package com.book.app.service;

import java.util.List;

import com.book.app.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	public Customer saveCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public void deleteCustomer(int customerId);
	public Customer modifyCustomer(int customerId);
}
