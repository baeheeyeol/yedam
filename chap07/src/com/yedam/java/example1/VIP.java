package com.yedam.java.example1;

public class VIP extends Customer {
	double discountRate;
	String agent;

	public VIP() {
		this.customerGrade = "VIP";
		this.bonusRatio = 0.05;
		this.discountRate = 0.15;
	}

	public VIP(int customerId, String customerName, String agent) {
		super(customerId, customerName);
		this.customerGrade = "VIP";
		this.bonusRatio = 0.05;
		this.discountRate = 0.15;
		this.agent = agent;
	}

	@Override
	public int calcPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		return (int) (price * (1 - this.discountRate));
	}

	@Override
	public String showInfo() {
		return super.showInfo() + "\n" + "담당 상담원은 " + agent + "입니다.";
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

}