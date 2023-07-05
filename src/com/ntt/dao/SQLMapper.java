package com.ntt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ntt.dbfw.ResultMapper;
import com.ntt.domain.Country;

// in oracle or mysql
// create a table named tbl_country 
// create table tbl_country(id numeric(4), name varchar2(30)); in your database ... 

/*
 * then you can import this project to your workspace..
 * add the related libraries... to your project..  
 * execute this project... 
 */


 
public class SQLMapper
{
	
	public static final String FETCHCOUNTRY= "select * from tbl_country";  
	
	public static final String FETCHCOUNTRYID= "select id,name from tbl_country where id=? and name=?";
	
	public static final String INSERTCOUNTRY= "insert into tbl_country values(?,?)";
	
	public static final String INSERTSTUDENT = "insert into tbl_nttstudent777 values(?,?,?)";
	
	public static final String SELLERDETAILS = "Select sellerid, sellername, sellerphone, selleremail from tblseller where sellerid=?";
	
	public static final String FETCHCOUNTRYNAME= "select name from tbl_country where id=? and name=?";
	
	
	// ResultSet List<Object> : Student/ Employee/Product..  
	
	public static final ResultMapper FETCHCOUNTRYNAMEOUTMAPER = new ResultMapper()
	{
	//resultmapper-outmapper	
		public Object mapRow(ResultSet rs) throws SQLException // 10 records 
        {
	 
		String name=rs.getString(1);   
		Country c=new Country(name);  // Country c = new Country(id, name, pop
		return c;
		}
	//executequery()	 method will execute the above querry and return the obj of resultset where using obj rs we can 
			//get datas from database.
				
	};
	
	
	
	public static final ResultMapper COUNTRYMAPPER = new ResultMapper()
	{
		
		public Object mapRow(ResultSet rs) throws SQLException // 10 records 
        {
			
		int id=	rs.getInt(1); 
		String name=rs.getString(2);   
		
		
		Country c=new Country(id,name);  // Country c = new Country(id, name, pop
		return c;
		}
		
				
	};
	
	
	
	
	
	
	
	
	
	//  select count(*) as login where username=? and password=?
	// rs = executeQuery();
	// int userc = Integer.parseint(rs.getInt("login"));
	
	
	
	//Anonymous class
	// select sellerid, sellername, sellerphone, selleremail from tblseller where sellerid=?
//	
//	public static final ResultMapper sellermapper = new ResultMapper()
//	{
//		
//		public Object mapRow(ResultSet rs) throws SQLException
//        {
//			
//		int id=	rs.getInt(1);// ID
//		String name=rs.getString(2); // S..NAME
//		String phone = rs.getString(3);
//		String email = rs.getString(4);
//		
//		
//		Seller s=new Country(id,name);  // Country c = new Country(id, name, pop)
//		
//		
//			return c;
//		}
//		//mapRow
//		
//	};
//	//Anonymous class
	 
	//Anonym
	
	 
	
}
 





