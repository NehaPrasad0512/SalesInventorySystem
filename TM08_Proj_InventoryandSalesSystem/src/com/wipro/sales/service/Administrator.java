package com.wipro.sales.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;
import com.wipro.sales.util.DBUtil;

public class Administrator {
Product p=new Product();

	
public String insertStock(Product stockobj) {
		StockDao gseq=new StockDao();
		String generatorseq=null;
		if(stockobj!=null) {
			if(stockobj.getProductName().length()>=2) {
				generatorseq=gseq.generateProductID(stockobj.getProductName());
				stockobj.setProductID(generatorseq);
				gseq.insertStock(stockobj);
			}
			return generatorseq;
		}
		else {
		return "Date not Valid for insertion";
		}
	}
	
	public String deleteStock(String ProductID) {
		StockDao stockd=new StockDao();
		int row=stockd.deleteStock(ProductID);
		if(row!=0) {
			System.out.println("deleted");
			return ProductID;	
		}
		else
			return "record cannot be deleted";

	}
	public String insertSales(Sales salesobj) throws ParseException {

		StockDao s=new StockDao();
		String ppquery="Select * from TBL_STOCK where TBL_STOCK.PRODUCT_ID=?";
		int valsearch=0;
		Connection c=DBUtil.getDBConnection();
		try {
		PreparedStatement stmt = c.prepareStatement(ppquery);
		stmt.setString(1, salesobj.getProductID());
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
		 valsearch=rs.getInt(3);
		}
		}catch(SQLException se) {
	System.out.println(se.getClass());
}	
		if(salesobj!=null) {
			
			System.out.println("Quantity of Product available: "+valsearch);
			
			System.out.println("Quantity sold: "+salesobj.getQuantitySold());
			
			if(salesobj.getProductID()!=null) {
					if(valsearch>salesobj.getQuantitySold()) 
					{
						Date dnow=new Date();
						if(salesobj.getSalesDate().before(dnow) || salesobj.getSalesDate().equals(dnow)) {
							SalesDao d =new SalesDao();
							salesobj.setSalesID(d.generateSalesID(salesobj.getSalesDate()));
							System.out.println("Inserting values");
							int row1=d.insertSales(salesobj);
							System.out.println("Updating values");
						int row2=s.updateStock(salesobj.getProductID(), salesobj.getQuantitySold(),valsearch);
						if(row1==1 && row2==1) {
							return "Sales completed";}
						else {
							return"Error";
						}	}
						else {
						return "Invalid date";					}
					}
					else {
						String str="Not enough stock on hand for sales";
						return str;	}
			}
			else {
				return "Unknown Product for sales";}
		}else {
			return "Object not valid for insertion";
		}	
	}
	
	public ArrayList<SalesReport> getSalesReport(){
		SalesDao sd=new SalesDao();
		ArrayList<SalesReport> sl=sd.getSalesReport();
		return sl;
		
		
	}
}
