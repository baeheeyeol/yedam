package com.yedam.java.ch1501;

public class MainTest {
	public static void main(String[] args) {
		Bag bag = new Bag();

		bag.set(new Note());
		Note note = (Note) bag.get();

		bag.set("신운하");
		String name = (String) bag.get();

		Box<Note, String, Integer> box = new Box<>();

		box.setT(new Note());
		box.setK(500);
		box.setV("홍길동");

		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();

		Box<Car, Bus, Texi> vehicle = new Box<>();
		vehicle.setT(new Car());
		vehicle.setV(new Bus());
		vehicle.setK(new Texi());

		Car car = vehicle.getT();
		Bus bus = vehicle.getV();
		Texi texi = vehicle.getK();
	}

}

class Car {
}

class Bus {
}

class Texi {
}