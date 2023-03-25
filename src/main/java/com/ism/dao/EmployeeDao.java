package com.ism.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ism.bean.EmployeeBean;
import com.ism.util.DbConnection;

public class EmployeeDao 
{
	public int insert(EmployeeBean ebean) 
	{
		String insertQuery = "INSERT INTO employee(name,salary,dsgn,orgName) VALUES('"+ebean.getName()+"','"+ebean.getSalary()+"','"+ebean.getDsgn()+"','"+ebean.getOrgName()+"')";

		System.out.println("insertQuery : " + insertQuery);

		Connection conn = DbConnection.getConnection();
		
		Statement stmt= null;
		
		int rowAffected = 0 ;
		
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rowAffected = stmt.executeUpdate(insertQuery);
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("EmployeeDao -- insert()---Db not Connected");
		}
		return rowAffected;
	}
	public  void update() 
	{

	}
	public  void delete() 
	{

	}
	public  void getAllRecords() 
	{

	}
	public static void main(String[] args) 
	{
		EmployeeBean e = new EmployeeBean(0, "Ankur", "3245", "Dr", "ABC");
		
		EmployeeDao dao = new EmployeeDao();
		
		int rowAffected = dao.insert(e);
		if (rowAffected > 0 ) 
		{
			System.out.println("Employee records inserted : " + rowAffected);
		} else 
		{
			System.out.println("Employee records not inserted : " + rowAffected);
		}
	}
}
