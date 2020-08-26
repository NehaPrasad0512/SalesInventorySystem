package com.wipro.sales.main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.service.Administrator;


public class SalesApplication {

	public static void main(String args[]) throws ParseException {
		int ch;
		Administrator a=new Administrator();

		Product s1=new Product();
		Sales s2=new Sales();
		Scanner sc=new Scanner(System.in);
		int choice=6;
				while(choice==6) {
					System.out.println("Main Menu");
					System.out.println("1. Insert Stock");
					System.out.println("2. Delete Stock");
					System.out.println("3. Insert Sales");
					System.out.println("4. View Sales Report");
					System.out.println("5. Exiting ");
			System.out.println("Enter the option:");
			ch=sc.nextInt();
			ArrayList<SalesReport> asr;
			switch(ch) {
			case 1:
					System.out.print("Enter the product id:");
					String p1=sc.next();
					sc.nextLine();
					System.out.print("Enter the product name:");
					String p2=sc.next();
					sc.nextLine();
					System.out.print("Enter the quantity on hand:");
					int p3=sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the product unit price:");
					double p4=sc.nextDouble();
					sc.nextLine();
					System.out.print("Enter the recorder level:");
					int p5=sc.nextInt();
					sc.nextLine();
					s1.setProductID(p1);
					s1.setProductName(p2);
					s1.setQuantityOnHand(p3);
					s1.setProductUnitPrice(p4);
					s1.setRecorderLevel(p5);
					String st=a.insertStock(s1);
					System.out.println(st);
					break;
			case 2:
				System.out.print("Enter the product id to delete:");
				String d1=sc.next();
				sc.nextLine();
				String status=a.deleteStock(d1);
				System.out.println(status);
					break;
			case 3:
				System.out.print("Enter the sales id:");
				String e1=sc.next();
				sc.nextLine();
				System.out.print("Enter the sales date:");
				String e=sc.next();
				SimpleDateFormat sf=new SimpleDateFormat("dd/mm/yyyy");
				Date e2=sf.parse(e);
				sc.nextLine();
				System.out.print("Enter the product id:");
				String e3=sc.next();
				sc.nextLine();
				System.out.print("Enter the quantity sold:");
				int e4=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the sales price per unti:");
				double e5=sc.nextDouble();
				sc.nextLine();
				s2.setSalesID(e1);
				s2.setSalesDate(e2);
				s2.setProductID(e3);
				System.out.println(s2.getProductID());
				s2.setQuantitySold(e4);
				s2.setSalesPricePerUnit(e5);
				String val=a.insertSales(s2);
				System.out.println(val);
					break;
			case 4:
					System.out.println("Sales Report");
					//System.out.println(a.getSalesReport().toString());
					asr = a.getSalesReport();
					for(int i=0;i<asr.size();i++) {
						System.out.println(asr.get(i).toString());
					}
					break;
			case 5:System.out.println("Exiting ");
					System.exit(0);
			default:break;
			}
			
		}//end of while
	}
	
}