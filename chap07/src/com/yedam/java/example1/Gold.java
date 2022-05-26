package com.yedam.java.example1;

public class Gold extends Customer {
	double discountRate;

	public Gold() {
		this.bonusRatio = 0.02;
		this.discountRate = 0.1;
	}
	
	public Gold(int customerId, String customerName) {
		super(customerId, customerName);
		this.customerGrade = "GOLD";
		this.bonusRatio = 0.02;
		this.discountRate = 0.1;
	}

	@Override
	public int calcPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		return (int) (price * (1 - this.discountRate));
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	double getDiscountRate() {
		return discountRate;
	}
}
