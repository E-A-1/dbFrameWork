package com.ntt.domain;



public class Country 
{
	private int cid;
	private String cname;
	
	 

	public Country( String cname) 
	{
		 super();
	 
		this.cname = cname;
	}
	
	public Country(int cid, String cname) 
	{
		super();
		this.cid = cid;
		this.cname = cname;
	}
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	 
	
	public String toString()
	{
		return ("CountryID-"+cid+", CountryName-"+cname).toString();
	}
 
	
	
}
