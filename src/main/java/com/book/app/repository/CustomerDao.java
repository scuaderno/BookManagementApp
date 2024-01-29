package com.book.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.book.app.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer>{

}
