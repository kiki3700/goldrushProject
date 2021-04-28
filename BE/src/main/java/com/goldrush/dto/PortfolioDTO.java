package com.goldrush.dto;

public class PortfolioDTO {
	private String code;
	private int avePrice;
	private int quantity;
	private int price;
	private float rateOfReturn;
	
	public PortfolioDTO() {
	}
	
	public PortfolioDTO(String code, int avePrice, int quantity, int price, float rateOfReturn) {
		super();
		this.code = code;
		this.avePrice = avePrice;
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
	public int getAvePrice() {
		return avePrice;
	}
	public void setAvePrice(int avePrice) {
		this.avePrice = avePrice;
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
		return "PortfolioDTO [code=" + code + ", avePrice=" + avePrice + ", quantity=" + quantity + ", price=" + price
				+ ", rateOfReturn=" + rateOfReturn + "]";
	}
}
