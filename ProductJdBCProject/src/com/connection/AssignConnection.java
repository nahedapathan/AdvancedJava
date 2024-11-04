package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AssignConnection {
	
	public Connection setConnection()
	{
		Connection conn=null;
		try {
			//1.Register the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.Create Connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch191","root","tiger");
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}

}
