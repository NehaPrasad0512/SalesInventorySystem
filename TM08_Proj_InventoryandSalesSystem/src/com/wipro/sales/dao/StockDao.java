package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.sales.bean.Product;
import com.wipro.sales.util.DBUtil;

public class StockDao {
	PreparedStatement stmt;
	Connection c=DBUtil.getDBConnection();
	
	public int insertStock(Product sales){
			
		 try {
			 	stmt = c.prepareStatement("Insert into TBL_STOCK values(?,?,?,?,?)");
				stmt.setString(1,sales.getProductID());
				stmt.setString(2,sales.getProductName());
				stmt.setInt(3,sales.getQuantityOnHand());
				stmt.setDouble(4,sales.getProductUnitPrice());
				stmt.setInt(5,sales.getRecorderLevel());
				int row=stmt.executeUpdate();
				return row;
			}
			catch (SQLException e) {
				e.printStackTrace();
				return 0;	}
	}
	 
	 public String generateProductID(String productName) {
		 String StockID=productName.substring(0,2);
		 int r_seq=0;
			try {
				String sql="SELECT SEQ_PRODUCT_ID.NEXTVAL FROM DUAL";
				
				stmt=c.prepareStatement(sql);
				ResultSet r=stmt.executeQuery();
				while(r.next()) {
					r_seq=r.getInt(1);
				}
					StockID=StockID+r_seq;
							
			return StockID;
			}
			
			catch (SQLException e) {
				System.out.println(e.getClass());
				return null;
			}
		
		 
	 }
	 
	 public int updateStock(String productID,int soldQty,int valsearch){
		
		 String up_sql="UPDATE TBL_STOCK SET QUANTITY_ON_HAND=? WHERE TBL_STOCK.PRODUCT_ID=?";
			try {
				int q=valsearch-soldQty;
				stmt=c.prepareStatement(up_sql);
				stmt.setInt(1, q);
				stmt.setString(2,productID);
				int row=stmt.executeUpdate();
				return row;
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		 
	 }
	 
	public Product getStock(String productID){
		 Product p = null;
			String sql="Selct * from TBL_STOCK where TBL_STOCK.PRODUCT_ID=?";
			try {
				stmt=c.prepareStatement(sql);
				stmt.setString(1, productID);
				
				ResultSet r=stmt.executeQuery();
				while(r.next()) {
					p.setProductID(r.getString(1));
					p.setProductName(r.getString(2));
					p.setProductUnitPrice(r.getDouble(3));
					p.setQuantityOnHand(r.getInt(4));
					p.setRecorderLevel(r.getInt(5));
				}
			return p;
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		 
	 }
	
	 
	public int deleteStock(String productID){
	String d_sql="DELETE from TBL_STOCK where TBL_STOCK.PRODUCT_ID=?";	
	try {
		stmt=c.prepareStatement(d_sql);
		stmt.setString(1,productID);
		int row=stmt.executeUpdate();
		return row;
	}
	catch (SQLException e) {
		e.printStackTrace();
		return 0;}
	 }
	 
	 
}
