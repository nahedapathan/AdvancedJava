package com.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.AssignConnection;
import com.model.Products;

public class ReadProduct {

	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	public void readData()
	{
		ArrayList<Products> list=new ArrayList<Products>();
		//2.Create Connection
		conn=new AssignConnection().setConnection();
		
		try {
			//3.Create Statement
			stmt=conn.createStatement();
			//4.sql query
			String query="SELECT * FROM PRODUCTS";
			
			//5.Execute query
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				Products p=new Products();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setQuantity(rs.getInt(4));
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		for(Products p:list)
		{
			System.out.println(p);
		}
		
	}
}
