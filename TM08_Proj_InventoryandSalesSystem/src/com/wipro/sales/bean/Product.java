package com.wipro.sales.bean;

public class Product {

	String productID;
	String productName;
	int quantityOnHand;
	double productUnitPrice;
	int recorderLevel;
	
	
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
	public int getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public int getRecorderLevel() {
		return recorderLevel;
	}
	public void setRecorderLevel(int recorderLevel) {
		this.recorderLevel = recorderLevel;
	}
	
	
	
}
