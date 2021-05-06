package com.goldrush.dto;

public class PortfolioDTO {
	private String code;
	private String name;
	private int averagePrice;
	private int quantity;
	private int price;
	private float rateOfReturn;
	public PortfolioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PortfolioDTO(String code, String name, int averagePrice, int quantity, int price, float rateOfReturn) {
		super();
		this.code = code;
		this.name = name;
		this.averagePrice = averagePrice;
		this.quantity = quantity;
		this.price = price;
		this.rateOfReturn = rateOfReturn;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getRateOfReturn() {
		return rateOfReturn;
	}
	public void setRateOfReturn(float rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}
	@Override
	public String toString() {
		return "PortfolioDTO [code=" + code + ", name=" + name + ", averagePrice=" + averagePrice + ", quantity="
				+ quantity + ", price=" + price + ", rateOfReturn=" + rateOfReturn + "]";
	}

}
