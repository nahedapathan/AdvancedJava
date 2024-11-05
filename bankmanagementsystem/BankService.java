package com.day04.bankmanagementsystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankService {

	private List<Account> listOfaccount;
	private AccountDAO accountdao;
	
	public BankService() throws ClassNotFoundException, SQLException {
		listOfaccount=new ArrayList<Account>();
		accountdao=new AccountDAO();
	}
	
	//Add account
	public void addAccount(Account account) throws SQLException
	{
		listOfaccount.add(account);
		accountdao.addAccount(account);
	}
	
	//Show account
	public List<Account> getAllAccount() throws SQLException
	{
		listOfaccount=accountdao.getAccount();
		return listOfaccount;
	}
	
	//update account
	public void depositAccount(int accountNumber,double amount) throws SQLException
	{
		accountdao.updateAccount(new Account(accountNumber,"",amount));
	}
	
	//update account
	public void withdrawAccount(int accountNumber,double amount) throws SQLException
	{
		accountdao.withdrawAccount(new Account(accountNumber,"",amount));
	}
	
	
	public void close() throws SQLException
	{
		accountdao.close();

	}
}
