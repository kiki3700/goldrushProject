package com.goldrush.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TradeDTO {
	private int tradesId;
	private int offersId;
	private int membersId;
	private Timestamp timeStamp;
	
	public TradeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TradeDTO(int tradesId, int offersId, int membersId, Timestamp timeStamp) {
		super();
		this.tradesId = tradesId;
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
		return "TradeDTO [tradesId=" + tradesId + ", offersId=" + offersId + ", membersId=" + membersId + ", timeStamp="
				+ timeStamp + "]";
	}
	


	
}
