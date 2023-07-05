package com.ntt.domain;

public class Student1 
{
	
	
	public Student1(int stuid, String stname, String stpassword) {
		super();
		this.stuid = stuid;
		this.stname = stname;
		this.stpassword = stpassword;
	}
	
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStpassword() {
		return stpassword;
	}
	public void setStpassword(String stpassword) {
		this.stpassword = stpassword;
	}

	
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stname=" + stname + ", stpassword=" + stpassword + "]";
	}


	private int stuid ;
	private String stname;
	private String stpassword;
	

}
