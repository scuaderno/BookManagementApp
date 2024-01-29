package com.book.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int book_refno;
	private String book_title;
	private BigDecimal book_price;
	private int quantity;
	private int year_published;
	private String author;
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
