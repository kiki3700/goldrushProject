package com.goldrush.dto;

import java.time.LocalDateTime;

public class TradeDTO {
	private int tradesId;
	private int unitPrice;
	private int quantity;
	private int offersId;
	private int membersId;
	private LocalDateTime timeStamp;
	
	public TradeDTO() {

	}
	
	public TradeDTO(int tradesId, int unitPrice, int quantity, int offersId, int membersId, LocalDateTime timeStamp) {
		super();
		this.tradesId = tradesId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.offersId = offersId;
		this.membersId = membersId;
		this.timeStamp = timeStamp;
	}
	
	
	public int getTradesId() {
		return tradesId;
	}
	public void setTradesId(int tradesId) {
		this.tradesId = tradesId;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOffersId() {
		return offersId;
	}
	public void setOffersId(int offersId) {
		this.offersId = offersId;
	}
	public int getMembersId() {
		return membersId;
	}
	public void setMembersId(int membersId) {
		this.membersId = membersId;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "TradeDTO [tradesId=" + tradesId + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", offersId="
				+ offersId + ", membersId=" + membersId + ", timeStamp=" + timeStamp + "]";
	}
}
