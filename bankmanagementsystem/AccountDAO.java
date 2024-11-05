package com.day04.bankmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

	private Connection connection;

	public AccountDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB","root","tiger");
	}
	
	// Add 
	public void addAccount(Account account) throws SQLException
	{
		String query="INSERT INTO accounts VALUES(?,?,?)";
		PreparedStatement pstmt=connection.prepareStatement(query);
		
		pstmt.setInt(1, account.getAccNo());
		pstmt.setString(2, account.getAccName());
		pstmt.setDouble(3, account.getAccBalance());
		
		pstmt.executeUpdate();
	}
	
	//Update--deposit
	public void updateAccount(Account account) throws SQLException
	{
		String query="UPDATE accounts SET balance = balance + ? WHERE account_number=?";
		PreparedStatement pstmt=connection.prepareStatement(query);
		
		pstmt.setDouble(1, account.getAccBalance());
		pstmt.setInt(2, account.getAccNo());
		
		int row=pstmt.executeUpdate();
		if(row==0)
		{
			System.out.println("UnSuccessfull Transaction ");
		}
		else
		{
			System.out.println("Amount Deposit Successfully...");
		}
	}
	
	//update--withdraw
	public void withdrawAccount(Account account) throws SQLException
	{
		String query="UPDATE accounts SET balance=balance-? WHERE account_number=?";
		PreparedStatement pstmt=connection.prepareStatement(query);
		
		pstmt.setDouble(1, account.getAccBalance());
		pstmt.setInt(2, account.getAccNo());
		
		int rows=pstmt.executeUpdate();
		if(rows==0)
		{
			System.out.println("Withdrawl failed Account not found or insufficient funds.");
		}
		else
		{
			System.out.println("Amount withdraw Successfully...");
		}
		
	}
	
	//View 
	public List<Account> getAccount() throws SQLException
	{
		List<Account> accounts=new ArrayList<Account>();
		Statement stmt=connection.createStatement();
		
		String query="SELECT * FROM ACCOUNTS";
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next())
		{
			Account account=new Account(rs.getInt("account_number"),rs.getString("name"),rs.getDouble("balance"));
			accounts.add(account);
		}
		return accounts;
	}
	
	
	public void close() throws SQLException
	{
		connection.close();
	}
	
	
}
