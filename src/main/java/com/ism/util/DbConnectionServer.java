package com.ism.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionServer 
{
	// 1) Make Credentials
	private static final String URLNAME    = "jdbc:sqlserver://localhost:49472;DatabaseName=rahuldb";
	private static final String DRIVERCLASS= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String USERNAME   = "sa";
	private static final String PASSWORD   = "rahul@1234";

	// 2) create getConnection method
	public static Connection getConnection() 
	{
		Connection conn = null;
		try 
		{
			// 3) load Driver Class
			Class.forName(DRIVERCLASS);
			// 4) pass credential into DriverManager's getConnection method
			 conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) 
	{
		Connection conn = getConnection();

		// 5) validate  conn object
		 
		 if (conn!=null) 
		 {
			 try 
			 {
				 DatabaseMetaData db = conn.getMetaData();
				 System.out.println("db.getUserName() - " + db.getUserName());
				 System.out.println("db.getDatabaseProductName() : " + db.getDatabaseProductName());
				 String product_name = db.getDatabaseProductName();
				 System.out.println("product_name : " + product_name);
			 } catch (SQLException e) 
			 {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("Db Conected : " + conn);
		} else 
		{
			 System.out.println("Db not Conected : " + conn);
		}
	}
}
