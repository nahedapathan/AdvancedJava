package com.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.AssignConnection;
import com.model.Products;

public class DeleteProduct {
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public void deleteData(Products p)
	{
		//2.Connection
		conn=new AssignConnection().setConnection();
		//3.Sql query
		String query="DELETE FROM PRODUCTS WHERE ID=?";
		
		try {
			//4.Create stmt
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, p.getId());
			
			//5.Execute
			int rows=pstmt.executeUpdate();
			System.out.println(rows+" deleted");
			
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
