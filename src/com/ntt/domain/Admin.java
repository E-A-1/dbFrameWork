package com.ntt.domain;

public class Admin {

private int adminid;
private String passsword;
private String adminName;
private String email;
private int contactNumber;

public Admin(int adminid, String passsword, String adminName, String email, int contactNumber) {
	super();
	this.adminid = adminid;
	this.passsword = passsword;
	this.adminName = adminName;
	this.email = email;
	this.contactNumber = contactNumber;
}

public int getAdminid() {
	return adminid;
}

public void setAdminid(int adminid) {
	this.adminid = adminid;
}

public String getPasssword() {
	return passsword;
}

public void setPasssword(String passsword) {
	this.passsword = passsword;
}

public String getAdminName() {
	return adminName;
}

public void setAdminName(String adminName) {
	this.adminName = adminName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getContactNumber() {
	return contactNumber;
}

public void setContactNumber(int contactNumber) {
	this.contactNumber = contactNumber;
}
@Override
public String toString() {
	return "Admin [adminid=" + adminid + ", passsword=" + passsword + ", adminName=" + adminName + ", email=" + email
			+ ", contactNumber=" + contactNumber + "]";
}
}
