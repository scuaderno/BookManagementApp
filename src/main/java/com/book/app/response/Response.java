package com.book.app.response;

import java.io.Serializable;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum statCode {
		success("0000"), 
		error("9999");

		private String statusCode;

		statCode(String statusCode) {
			this.statusCode = statusCode;
		}
		
		public String getStatusCode() {
	        return statusCode;
	    }
	}

	public enum statName {
		success("Success"), 
		error("Error");

		private String statusName;

		statName(String statusName) {
			this.statusName = statusName;
		}
		public String getStatusName() {
	        return statusName;
	    }
	}

	public enum statDesc {
		success("Successfully processed"), 
		error("Error During Processing");

		private String statusDesc;

		statDesc(String statusDesc) {
			this.statusDesc = statusDesc;
		}
		public String getStatusDesc() {
	        return statusDesc;
	    }
	}

	private String statusCode;
	private String statusName;
	private String statusDesc;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}
