package com.goldrush.dto;

import java.sql.Timestamp;

public class TradeLogDTO {
	private String code;
	private String name;
	private int price;
	private int quantity;
	private boolean buy;
	private Timestamp timestamp;

	public TradeLogDTO() {
		super();
	}

	public TradeLogDTO(String code, String name, int price, int quantity, boolean buy, Timestamp timestamp) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.buy = buy;
		this.timestamp = timestamp;
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
	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "TradeLogDTO [code=" + code + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", buy="
				+ buy + ", timestamp=" + timestamp + "]";
	}
}
