package com.goldrush.dto;

public class PortfolioDTO {
	private String code;
	private int averagePrice;
	private int quantity;
	private int price;
	private float rateOfReturn;
	public PortfolioDTO() {
		super();
	}
	public PortfolioDTO(String code, int averagePrice, int quantity, int price, float rateOfReturn) {
		super();
		this.code = code;
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
		return "PortfolioDTO [code=" + code + ", averagePrice=" + averagePrice + ", quantity=" + quantity + ", price="
				+ price + ", rateOfReturn=" + rateOfReturn + "]";
	}
	

}
