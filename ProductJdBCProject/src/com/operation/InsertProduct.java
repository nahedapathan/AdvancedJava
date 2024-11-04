package com.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.AssignConnection;
import com.model.Products;

public class InsertProduct {
	Connection conn=null;
	PreparedStatement pstmt=null;
	String query;
	public void insertWithId(Products p)
	{
		conn=new AssignConnection().setConnection();
		//3.QUERY
		query="INSERT INTO PRODUCTS VALUES(?,?,?,?)";
		
		try {
			//4.Create ststement
			pstmt=conn.prepareStatement(query);
			
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setDouble(3, p.getPrice());
			pstmt.setInt(4, p.getQuantity());
			
			
			//5.Execute
			int rows=pstmt.executeUpdate();
			System.out.println(rows+" inserted !");
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	public void insertWithoutId(Products p)
	{
		conn=new AssignConnection().setConnection();
		//3.QUERY
		query="INSERT INTO PRODUCTS(name,price,quantity) VALUES(?,?,?)";
		
		try {
			//4.Create ststement
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, p.getName());
			pstmt.setDouble(2, p.getPrice());
			pstmt.setInt(3, p.getQuantity());
			
			//5.Execute
			int rows=pstmt.executeUpdate();
			System.out.println(rows+" inserted !");
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
	}

}
