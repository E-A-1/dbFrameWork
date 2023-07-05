package com.ntt.dbcon;

import javax.sql.DataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;


import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/*uid=root
pwd=
url=jdbc:mysql://localhost:3306/nttdatadb1
driver=com.mysql.jdbc.Driver
*/
/*
uid=NTT
pwd=9846063857!Symbol
url=jdbc:oracle:thin:@localhost:1521:xe
driver=oracle.jdbc.driver.OracleDriver
*/





public class ConnectionHolder 
{
	
	
	private static ConnectionHolder connectionHolderInstance = null;
	private DataSource ds = null;
	
	private ConnectionHolder()
	{
		
	}
	
	// 1. 
	 
	private void initAppDatasource() throws DBConnectionException 
	{

		
		try {

			BasicDataSource bds = new BasicDataSource();
			Properties ps = new Properties();
			ps.load(new FileInputStream("jdbcds.properties")); 
			
			String uid = ps.getProperty("uid");
			String pwd = ps.getProperty("pwd");
			String URL = ps.getProperty("url");
			String driverclazz = ps.getProperty("driver");

			bds.setUrl(URL);
			bds.setDriverClassName(driverclazz);
			bds.setUsername(uid);
			bds.setPassword(pwd);

			this.ds = bds;

		} catch (FileNotFoundException e) {

			throw new DBConnectionException
			("Unable to get connection Data to the database"+ e);

		} catch (IOException e) {

			throw new DBConnectionException("Unable to get connection Data to the database", e);
		}
	}
	// Used during web application instead of the above method
	// private void initAppserverDatasource()
	// {
	//     
	// }
	

	public static ConnectionHolder getInstance() throws DBConnectionException 
	{
		//	happens only once
		synchronized (ConnectionHolder.class) 
		{
			// use reflection to synchronize as we have no object
			if (connectionHolderInstance == null)
			{
				connectionHolderInstance = new ConnectionHolder();
				// Replace this line for Web Application
				connectionHolderInstance.initAppDatasource();
			}
		}
		return connectionHolderInstance;
	}

	
	
	public Connection getConnection() throws DBConnectionException
	{

		try 
		{

			return ds.getConnection();  // establish db connection .. 
			
			
		} catch (SQLException e) {

			throw new DBConnectionException("Unable to obtain a connection", e);
		}
	}
	
	
	public void dispose() throws DBConnectionException
	{

		BasicDataSource bds = (BasicDataSource) ds;
		try {

			bds.close();
		} catch (SQLException e) {

			throw new DBConnectionException("Unable to close the connection", e);
		}
	}
}
