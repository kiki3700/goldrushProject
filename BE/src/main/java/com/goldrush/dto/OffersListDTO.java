package com.goldrush.dto;

public class OffersListDTO {
	private int price;
	private int quantity;
	
	public OffersListDTO() {
		super();
	}

	public OffersListDTO(int price, int quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OffersListDTO [price=" + price + ", quantity=" + quantity + "]";
	}

}
