package com.ism.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	// select --Multiple Rows----ResultSet----executeQuery()
	public  ArrayList<EmployeeBean> getAllRecords() 
	{
		String selectQuery = "SELECT * FROM employee";
		Connection conn = DbConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		EmployeeBean ebean = null;
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(selectQuery);
				
				while(rs.next()) 
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String salary = rs.getString(3);
					String dsgn = rs.getString(4);
					String orgName = rs.getString(5);
					
					ebean = new EmployeeBean(id, name, salary, dsgn, orgName);
					list.add(ebean);
				}
				
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not connectec : " + conn);
		}
		return list;
	}
	public static void main(String[] args) 
	{
//		EmployeeBean e = new EmployeeBean(0, "Ankur", "3245", "Dr", "ABC");
		
		EmployeeDao dao = new EmployeeDao();
		
		ArrayList<EmployeeBean> list = dao.getAllRecords();
		
		for (int i = 0; i < list.size(); i++) 
		{
			EmployeeBean ebean =  list.get(i);

			System.out.println(ebean);
//			System.out.println(ebean.getId() + " " +ebean.getName() + " " +ebean.getSalary() + " " +ebean.getSalary() + " " +ebean.getOrgName());
		} 
		
		
		
//		int rowAffected = dao.insert(e);
//		if (rowAffected > 0 ) 
//		{
//			System.out.println("Employee records inserted : " + rowAffected);
//		} else 
//		{
//			System.out.println("Employee records not inserted : " + rowAffected);
//		}
	}
}
