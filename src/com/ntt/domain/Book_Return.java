package com.ntt.domain;

public class Book_Return {
private int requestid;


private String returnStatus;
private String returnDate;

public Book_Return(int requestid, String returnStatus, String returnDate) {
	super();
	this.requestid = requestid;
	this.returnStatus = returnStatus;
	this.returnDate = returnDate;
}


public int getRequestid() {
	return requestid;
}

public void setRequestid(int requestid) {
	this.requestid = requestid;
}

public String getReturnStatus() {
	return returnStatus;
}

public void setReturnStatus(String returnStatus) {
	this.returnStatus = returnStatus;
}

public String getReturnDate() {
	return returnDate;
}

public void setReturnDate(String returnDate) {
	this.returnDate = returnDate;
}
@Override
public String toString() {
	return "Book_Return [requestid=" + requestid + ", returnStatus=" + returnStatus + ", returnDate=" + returnDate
			+ "]";
}
}
