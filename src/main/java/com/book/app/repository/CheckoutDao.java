package com.book.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.book.app.entity.Checkout;

@Repository
public interface CheckoutDao extends JpaRepository<Checkout, Integer>, JpaSpecificationExecutor<Checkout>{

}
