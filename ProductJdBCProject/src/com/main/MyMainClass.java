package com.main;

import java.util.Scanner;

import com.model.Products;
import com.operation.DeleteProduct;
import com.operation.InsertProduct;
import com.operation.ReadProduct;
import com.operation.UpdateProduct;

public class MyMainClass {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("Enter the Choice \n1.Insert Product \n2.Update Product \n3.Delete Product \n4.Read Product ");
			choice=sc.nextInt();
			switch(choice)
			{     //insert code
			case 1:System.out.println("Enter 1 the product id or 0 without id");
			       choice=sc.nextInt();
			       if(choice==1)
			       {
			    	   System.out.println("Enter Id ,Name ,Price ,Quantity");
			    	   Products p=new Products(sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextInt());
				       new InsertProduct().insertWithId(p);
			       }
			       else
			       {
			    	   System.out.println("Enter Name ,Price Quantity");
			    	   Products p=new Products(sc.next(),sc.nextDouble(),sc.nextInt());
				       new InsertProduct().insertWithoutId(p);
			       }
			       break;
			       //update code
			case 2:System.out.println("Enter the update choice\n1.Update Name ,Price,Quantity \n2.Update Price,Quantity \n3.Update Quantity");
			       choice=sc.nextInt();
			       if(choice==1)
			       {
			    	   System.out.println("Enter Name Price quantity you want to update");
					   Products p=new Products(sc.next(),sc.nextDouble(),sc.nextInt());
				       System.out.println("Enter Id to change there  ");
				       p.setId(sc.nextInt());
				       new UpdateProduct().updateNamePriceQuantity(p);
			       }
			       else if(choice==2)
			       {
			    	   System.out.println("Enter Price Quantity you want to update");
			    	   Products p=new Products(sc.nextDouble(),sc.nextInt());
			    	   System.out.println("Enter Id to change There :");
			    	   p.setId(sc.nextInt());
			    	   new UpdateProduct().updatePriceQuantity(p);
			       }
			       else
			       {
			    	   System.out.println("Enter the Quantity you want to update");
			    	   Products p=new Products(sc.nextInt());
			    	   System.out.println("Enter the Id to Change there :");
			    	   p.setId(sc.nextInt());
			    	   new UpdateProduct().updateQuantity(p);
			       }
		           break;
			case 3:Products p=new Products();
			       System.out.println("Enter the Id ");
			       p.setId(sc.nextInt());
			       new DeleteProduct().deleteData(p);
			
		           break;
		         //read Product
			case 4:new ReadProduct().readData();
		           break;
		           
		    default:System.out.println("Please Enter Correct Choice");
		           break;
			}
			System.out.println("Are you want to continue Enter any number and to Stop Enter zero ?");
			choice=sc.nextInt();
			
		}while(choice!=0);
		System.out.println("Successfully Exit !!!");
	}

}
