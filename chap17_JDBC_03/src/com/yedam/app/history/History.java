package com.yedam.app.history;

public class History {
	private int productId;
	// 1 : 입고 , 2 : 출고
	private int productCategory;
	private int productAmount;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productcategory) {
		this.productCategory = productcategory;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

}
