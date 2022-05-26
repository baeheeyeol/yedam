package com.yedam.java.ch0702;

public class DriverTest {

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Taxi());
		driver.drive(new Vehicle());
	}

}
