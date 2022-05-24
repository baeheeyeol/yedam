package com.yedam.homework;

public class ProductSystem {
	private Product[] list;
	private int index;

	public ProductSystem() {
		index = -1;
	}

	// 1.상품 수 입력
	public void setListSize(int size) {
		list = new Product[size];
	}

	// 2.상품 및 가격 입력
	public void putProduct(String name, int price) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);

		list[++index] = product;
	}

	// 3.제품별 가격 출력
	public void printList() {
		for (int i = 0; i <= index; i++) {
			Product product = list[i];
			//System.out.println(list[i].getPrice());
			list[i].showInfo();
		}
	}

	// 4.분석
}
