package com.ntt.domain;

public class BookDetails {
private int bookid;


private String bookName;
private int ISBN;
private String aurthor;
private String publisher;
private String edition;
private int price;
private int quantity;
private String categoryName;

public BookDetails(int bookid, String bookName, int iSBN, String aurthor, String publisher, String edition, int price,
		int quantity, String categoryName) 
{
	super();
	this.bookid = bookid;
	this.bookName = bookName;
	ISBN = iSBN;
	this.aurthor = aurthor;
	this.publisher = publisher;
	this.edition = edition;
	this.price = price;
	this.quantity = quantity;
	this.categoryName = categoryName;
}
public int getBookid() {
	return bookid;
}

public void setBookid(int bookid) {
	this.bookid = bookid;
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public int getISBN() {
	return ISBN;
}

public void setISBN(int iSBN) {
	ISBN = iSBN;
}

public String getAurthor() {
	return aurthor;
}

public void setAurthor(String aurthor) {
	this.aurthor = aurthor;
}

public String getPublisher() {
	return publisher;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
}

public String getEdition() {
	return edition;
}

public void setEdition(String edition) {
	this.edition = edition;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
@Override
public String toString() {
	return "BookDetails [bookid=" + bookid + ", bookName=" + bookName + ", ISBN=" + ISBN + ", aurthor=" + aurthor
			+ ", publisher=" + publisher + ", edition=" + edition + ", price=" + price + ", quantity=" + quantity
			+ ", categoryName=" + categoryName + "]";
}
}
