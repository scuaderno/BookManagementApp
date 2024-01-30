package com.book.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="books")
@EntityListeners(AuditingEntityListener.class)
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_refno")
	private int book_refno;
	
	@Column(name="book_title")
	private String book_title;
	
	@Column(name="book_price")
	private BigDecimal book_price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="year_published")
	private int year_published;
	
	@Column(name="author")
	private String author;
	
	@Column(name="category")
	private String category;
	
	public int getBook_refno() {
		return book_refno;
	}
	public void setBook_refno(int book_refno) {
		this.book_refno = book_refno;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public BigDecimal getBook_price() {
		return book_price;
	}
	public void setBook_price(BigDecimal book_price) {
		this.book_price = book_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getYear_published() {
		return year_published;
	}
	public void setYear_published(int year_published) {
		this.year_published = year_published;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
