package com.book.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.app.entity.Checkout;

@Repository
public interface CheckoutDao extends JpaRepository<Checkout, Integer>, JpaSpecificationExecutor<Checkout>{

	@Query(value = "SELECT * FROM checkout c, customer a, books b WHERE c.book_id=b.book_refno AND c.customer_id=a.customer_refno AND c.isReturned=?", nativeQuery = true)
	public List<Checkout> findByIsReturned(String isReturned);
}
