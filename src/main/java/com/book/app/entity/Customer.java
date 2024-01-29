package com.book.app.entity;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int customer_refno;
	private String firstname;
	private String lastname;
	private String office_email;
	private String personal_email;
	private String mobile_number;
	private String status;
	
	
	public int getCustomer_refno() {
		return customer_refno;
	}
	public void setCustomer_refno(int customer_refno) {
		this.customer_refno = customer_refno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getOffice_email() {
		return office_email;
	}
	public void setOffice_email(String office_email) {
		this.office_email = office_email;
	}
	public String getPersonal_email() {
		return personal_email;
	}
	public void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
