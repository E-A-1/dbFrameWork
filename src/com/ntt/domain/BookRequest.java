package com.ntt.domain;

public class BookRequest {
private int requestid;
private int studentid;
private int bookid;
private String status;

public BookRequest(int requestid, int studentid, int bookid, String status) {
	super();
	this.requestid = requestid;
	this.studentid = studentid;
	this.bookid = bookid;
	this.status = status;
}
public int getRequestid() {
	return requestid;
}
public void setRequestid(int requestid) {
	this.requestid = requestid;
}
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
