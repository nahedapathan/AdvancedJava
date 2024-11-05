package com.day04.bankmanagementsystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BankService bankservice=new BankService();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("***Welcome to Citi Bank***");
		boolean exit=false;
		
		while(!exit)
		{
			System.out.println("1.Create Account: ");
			System.out.println("2.Deposit: ");
			System.out.println("3.Withdraw: ");
			System.out.println("4.View Account: ");
			System.out.println("5.Exit!");
			System.out.println("Enter the Choice: ");
			int choice=sc.nextInt();
			sc.nextLine();//Consume Line
			
			switch(choice)
			{
			case 1:System.out.println("Enter the Account Number: ");
			       int accno=sc.nextInt();
			       sc.nextLine();
			       System.out.println("Enter the Account Holder Name: ");
			       String name=sc.nextLine();
			       
			       System.out.println("Enter the Balance: ");
			       double balance=sc.nextDouble();
			       
			       Account newaccount=new Account(accno, name, balance);
			       bankservice.addAccount(newaccount);
			       System.out.println("Account Create Successfully!!!");
				   break;
				   
			case 2:System.out.println("Enter Account Number for Deposit: ");
			       int depositAcc=sc.nextInt();
			       System.out.println("Enter Deposit Amount: ");
			       double depositAmount=sc.nextDouble();
			       
			       bankservice.depositAccount(depositAcc, depositAmount);
				   break;
				   
			case 3:System.out.println("Enter the Account Number for Withdrawl: ");
			       int withdraw=sc.nextInt();
			       System.out.println("Enter Withdrawl Amount: ");
			       double withdrawAmount=sc.nextDouble();
			       
			       bankservice.withdrawAccount(withdraw, withdrawAmount);
			       
				   break;
			case 4:List<Account> accounts=bankservice.getAllAccount();
			       if(accounts.isEmpty())
			       {
			    	   System.out.println("No Account is Available................");
			       }
			       else
			       {
			    	   accounts.forEach(System.out::println);
			       }
				   break;
			case 5:exit=true;
			       bankservice.close();
			       System.out.println("Exit For the Application...........");
				   break;
			default:System.out.println("Please Choose the Correct Option");
				    break;
			}
			
		}
		
	}

}
