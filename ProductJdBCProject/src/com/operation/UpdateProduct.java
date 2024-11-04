package com.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.AssignConnection;
import com.model.Products;

public class UpdateProduct {
	Connection conn=null;
	PreparedStatement pstmt=null;
	String query;
	public void updateNamePriceQuantity(Products p)
	{
		//2.create Connection
		conn=new AssignConnection().setConnection();
		//3.sql query
		query="UPDATE PRODUCTS SET NAME=?,PRICE=?,QUANTITY=? WHERE ID=?";
		
		try {
			//4.Create Statement
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, p.getName());
			pstmt.setDouble(2, p.getPrice());
			pstmt.setInt(3, p.getQuantity());
			pstmt.setInt(4, p.getId());
			
			//5.Execute Statement
			int rows=pstmt.executeUpdate();
			
			System.out.println(rows+" updated");
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
	
	public void updatePriceQuantity(Products p)
	{
		conn=new AssignConnection().setConnection();
		query="UPDATE PRODUCTS SET PRICE=?,QUANTITY=? WHERE ID=?";
		
		try {
			//4.create stmt
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setDouble(1,p.getPrice());
			pstmt.setInt(2,p.getQuantity());
			pstmt.setInt(3, p.getId());
			
			//5.execute 
			int rows=pstmt.executeUpdate();
			System.out.println(rows+" Updated!");
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
	
	public void updateQuantity(Products p)
	{
		//2.Create connection
		conn=new AssignConnection().setConnection();
		//3.sql query
		query="UPDATE PRODUCTS SET QUANTITY=? WHERE ID=?";
		
		try {
			//4.Statement create
			PreparedStatement pstmt=conn.prepareStatement(query);
			
			pstmt.setInt(1, p.getQuantity());
			pstmt.setInt(2, p.getId());
			
			//5.Execute 
			int rows=pstmt.executeUpdate();
			System.out.println(rows+" Updated!");
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
