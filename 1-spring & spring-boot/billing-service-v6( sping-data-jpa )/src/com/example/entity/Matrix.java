package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Matrix {

	@Id
	private String itemCode;
	private int price;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
