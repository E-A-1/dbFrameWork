package com.ntt.dbfw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHelper

{
	public static List executeSelect(Connection con, final String sqlSt, ResultMapper outMap) throws DBFWException
	{
		List resultList=new ArrayList();
		Statement stmt=null;
		ResultSet rs=null;		
		try {
			 stmt=con.createStatement();
			 rs=stmt.executeQuery(sqlSt);
			 
			 while(rs.next()) // 1 by 1 object tru ..it will traverse...  and cast to the Country object 
			 {
				 // JAVA OBJECT = CONVERTED FROM TABLE ROWS INTO 
				 Object obj=outMap.mapRow(rs);
				 resultList.add(obj);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				throw new DBFWException("Execution of select failed",e);
	}finally{
			try {
				if(rs!=null)
				rs.close();
				if(stmt!=null)
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e);
			}		
	}
		
		return resultList;
		
	}//executeSelect	
	//Parameterized Select	
	
	// select id, name from tblempl where id = ?
	
	public static List executeSelect (Connection con,final String sqlSt, ResultMapper outMap,ParamMapper inMap)
	{
		List resultList=new ArrayList();
		PreparedStatement preStmt=null;
		ResultSet rs=null;
		
		try
		{
			preStmt=con.prepareStatement(sqlSt);
			
			inMap.mapParam(preStmt);
			
			rs=preStmt.executeQuery();
			
			while(rs.next())
			{
				Object ob=outMap.mapRow(rs);
				resultList.add(ob);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return resultList;
		
	}//parameterised exceuteselect
	
	//for insert,delete and update
	// insert tblcountry - id, name
	// insert tblemployee - empid, name, address, phone, ..
	// update tblemployee set name=?, address=? where empid = ?
	// update tblcountry set name=? where id=? 
	
	public static int executeUpdate (Connection con,final String sqlSt, ParamMapper inMap) throws DBFWException
	{
		PreparedStatement preStmt=null;
		
		int result=0;
		
		try 
		{
			preStmt=con.prepareStatement(sqlSt);  // public static final String INSERTCOUNTRY= "insert into country_081 values(?,?)";
			
			inMap.mapParam(preStmt);  // f1 f2 f3... 
			
			result=preStmt.executeUpdate(); // db    
			
		} 
		catch (SQLException e) 
		{
			throw new DBFWException("unable to insert"+e);
		}
		
		return result;
		
	}
}
