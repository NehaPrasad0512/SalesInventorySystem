package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;

public class SalesDao {
	DBUtil d=new DBUtil();
	PreparedStatement stmt;

	public int insertSales(Sales sales) throws ParseException {
			try {
				 java.util.Date d1 = sales.getSalesDate();
				SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
				String date=formatter.format(d1);
				java.util.Date dd=formatter.parse(date);
				java.sql.Date ddd=new java.sql.Date(dd.getTime());
			stmt = DBUtil.getDBConnection().prepareStatement("Insert into TBL_SALES values(?,?,?,?,?)");
			stmt.setString(1,sales.getSalesID());
			stmt.setDate(2,ddd);
			stmt.setString(3,sales.getProductID());
			stmt.setInt(4,sales.getQuantitySold());
			stmt.setDouble(5,sales.getSalesPricePerUnit());
			int row=stmt.executeUpdate();
			return row;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;	}
	}
	
	public String generateSalesID(java.util.Date salesDate) {
		SimpleDateFormat sdf=new SimpleDateFormat("yy");
		String SalesID=sdf.format(salesDate);
		int r_sequence=0;
		String sql="Select SEQ_SALES_ID.NEXTVAL from DUAL";
		try {
			stmt=DBUtil.getDBConnection().prepareStatement(sql);
			ResultSet r=stmt.executeQuery();
			while(r.next()) {
				r_sequence=r.getInt(1);
			}
			SalesID=SalesID+r_sequence;
		return SalesID;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<SalesReport> getSalesReport(){
		SalesReport sr=new SalesReport();
		String sqlv="Select * from V_SALES_REPORT";
		
		try {
			stmt=DBUtil.getDBConnection().prepareStatement(sqlv);
			ResultSet r=stmt.executeQuery();
			ArrayList<SalesReport> srp=new ArrayList<>();
			while(r.next()) {
						
			sr.setSalesID(r.getString(1));
			sr.setSalesDate(r.getDate(2));
			sr.setProductID(r.getString(3));
			sr.setProductName(r.getString(4));
			sr.setQuantitySold(r.getInt(5));
			sr.setProductUnitPrice(r.getDouble(6));
			sr.setSalesPricePerUnit(r.getDouble(7));
			sr.setProfitAmount(r.getDouble(8));
			srp.add(new SalesReport(sr.getSalesID(),sr.getSalesDate(),sr.getProductID(),sr.getProductName(),sr.getQuantitySold(),sr.getProductUnitPrice(),sr.getSalesPricePerUnit(),sr.getProfitAmount()));
			}
		
			return srp;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;

		
	
	}
	
	
	
	
}
