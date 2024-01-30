package com.book.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.app.entity.Customer;
import com.book.app.repository.CustomerDao;
import com.book.app.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDao.findById(customerId)
				.orElseThrow(() -> new EntityNotFoundException());
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer modifyCustomer(int customerId) {
		Optional<Customer> customer = customerDao.findById(customerId);
		if(customer.isPresent()) {
			Customer customerDetails = new Customer();
			customerDetails.setFirstname(customer.get().getFirstname());
			customerDetails.setLastname(customer.get().getFirstname());
			customerDetails.setMobile_number(customer.get().getMobile_number());
			customerDetails.setOffice_email(customer.get().getOffice_email());
			customerDetails.setPersonal_email(customer.get().getPersonal_email());
			customerDetails.setStatus(customer.get().getStatus());
			return saveCustomer(customerDetails);
		} else {
			logger.info("No Record Found for customer id: {}" + customerId);
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void deleteCustomer(int customerId) {
		Optional<Customer> customer = customerDao.findById(customerId);
		if(customer.isPresent()) {
			customerDao.delete(customer.get());
		} else {
			logger.info("Failed to delete customer id: {}" + customerId);
			throw new EntityNotFoundException();
		}
		 
	}

}
