package com.wipro.sales.bean;

import java.util.Date;

public class SalesReport {

	
	@Override
	public String toString() {
		return "SalesReport [salesID=" + salesID + ", salesDate=" + salesDate + ", productID=" + productID
				+ ", productName=" + productName + ", quantitySold=" + quantitySold + ", productUnitPrice="
				+ productUnitPrice + ", salesPricePerUnit=" + salesPricePerUnit + ", profitAmount=" + profitAmount
				+ "]";
	}
	String salesID;
	java.util.Date salesDate;
	String productID;
	String productName;
	int quantitySold;
	double productUnitPrice;
	double salesPricePerUnit;
	double profitAmount;
	
	
	
	public SalesReport() {
		super();
	}
	public SalesReport(String salesID, Date salesDate, String productID, String productName, int quantitySold,
			double productUnitPrice, double salesPricePerUnit, double profitAmount) {
		super();
		this.salesID = salesID;
		this.salesDate = salesDate;
		this.productID = productID;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.productUnitPrice = productUnitPrice;
		this.salesPricePerUnit = salesPricePerUnit;
		this.profitAmount = profitAmount;
	}
	public String getSalesID() {
		return salesID;
	}
	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}
	public java.util.Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(java.util.Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}
	public double getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(double profitAmount) {
		this.profitAmount = profitAmount;
	}
	
	
}
