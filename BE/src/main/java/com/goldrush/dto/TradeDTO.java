package com.goldrush.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TradeDTO {
	private int tradesId;
	private int quantity;
	private int offersId;
	private int membersId;
	private Timestamp timeStamp;
	
	public TradeDTO() {
		super();
	}
	
	public TradeDTO(int tradesId, int quantity, int offersId, int membersId, Timestamp timeStamp) {
		super();
		this.tradesId = tradesId;
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
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "TradeDTO [tradesId=" + tradesId + ", quantity=" + quantity + ", offersId=" + offersId + ", membersId="
				+ membersId + ", timeStamp=" + timeStamp + "]";
	}
	

	
}
