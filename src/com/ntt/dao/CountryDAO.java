package com.ntt.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;
import com.ntt.dbfw.ParamMapper;
import com.ntt.domain.Country;

public class CountryDAO
{
	
	
	
static Logger log=Logger.getLogger(CountryDAO.class);
	// select id, name from tblcountry ; /  -> outmapper 


public static List getCountries() throws DBFWException, CountryDAOException, DBConnectionException
	{
		
		List countries=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			log.debug("fetchig"); //
			
			countries=DBHelper.executeSelect(con,SQLMapper.FETCHCOUNTRY,SQLMapper.COUNTRYMAPPER);
					
		} catch (DBConnectionException e) {
			throw new DBConnectionException("Unable to connect to db"+e);
		
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		
		
		return countries;
		
	}//getcountry


//select name from tblcountry where id=?


public static List getCountry(final int cid,final String cname) // 22 INDIA// 
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List country=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
			 final ParamMapper COUNTRYPMAPPER=new ParamMapper()  // select id, name  from user where id=? password=? 
			 {

				public void mapParam(PreparedStatement preStmt) throws SQLException {
				preStmt.setInt(1,cid);
				preStmt.setString(2,cname);						
				}
				
			};//ananymous class
			
		country=DBHelper.executeSelect(con,SQLMapper.FETCHCOUNTRYID,SQLMapper.COUNTRYMAPPER, COUNTRYPMAPPER );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
		
	}//getcountry
	
	// dB Connection Pooling concept 
	 
	public static int insertCountry(final Country c)   // c.getcid, c.getName
	{
		
		
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance(); // to initialize datasource .// ds 
			con=ch.getConnection(); // get database connection ..
			
			
			final ParamMapper INSERTPCOUNTRY=new ParamMapper()
			{
				
				public void mapParam(PreparedStatement preStmt) throws SQLException 
				{
					preStmt.setInt(1, c.getCid());
					preStmt.setString(2, c.getCname());
					
				}
			};
			
			
			 
			 // STATEMENT EXECUTION MECHANISM 
		result=DBHelper.executeUpdate(con,SQLMapper.INSERTCOUNTRY,INSERTPCOUNTRY);// insert / delete/ update 
			
		// insert into tbl_country values(?,?) :   
		
		} 
		
		catch (DBFWException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}//insert
	
	


public static List getCountryName(final int cid,final String cname) // 22 INDIA// 
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List country=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
			 final ParamMapper COUNTRYPMAPPERNEW=new ParamMapper()  // select id, name  from user where id=? password=? 
			 {

				public void mapParam(PreparedStatement preStmt) throws SQLException {
				preStmt.setInt(1,cid);
				preStmt.setString(2,cname);						
				}
				
			};//ananymous class
			
		country=DBHelper.executeSelect(con,SQLMapper.FETCHCOUNTRYNAME,SQLMapper.FETCHCOUNTRYNAMEOUTMAPER , COUNTRYPMAPPERNEW );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
		
	}//getcountry
	




	
	
	
}
