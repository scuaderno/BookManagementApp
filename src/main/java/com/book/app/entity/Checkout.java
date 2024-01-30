package com.book.app.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="checkout")
@EntityListeners(AuditingEntityListener.class)
public class Checkout implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="checkout_refno")
	private int checkout_refno;
	
	@Column(name="start_time")
	private Timestamp start_time;
	
	@Column(name="end_time")
	private Timestamp end_time;
	
	@Column(name="book_id")
	private String book_id;
	
	@Column(name="customer_id")
	private String customer_id;
	
	@Column(name="isReturned")
	private String isReturned;
	
	public int getCheckout_refno() {
		return checkout_refno;
	}
	public void setCheckout_refno(int checkout_refno) {
		this.checkout_refno = checkout_refno;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getIsReturned() {
		return isReturned;
	}
	public void setIsReturned(String isReturned) {
		this.isReturned = isReturned;
	}
	
}
