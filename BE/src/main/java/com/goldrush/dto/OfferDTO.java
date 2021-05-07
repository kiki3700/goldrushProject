package com.goldrush.dto;

import java.sql.Timestamp;


public class OfferDTO {

	private int offersId;
	private int membersId;
	private int itemsId;
	private boolean buy;
	private int offerPrice;
	private boolean isComplete;
	private int quantity;
	private Timestamp timeStamp;
	
	public OfferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OfferDTO(int offersId, int membersId, int itemsId, boolean buy, int offerPrice, boolean isComplete,
			int quantity, Timestamp timeStamp) {
		super();
		this.offersId = offersId;
		this.membersId = membersId;
		this.itemsId = itemsId;
		this.buy = buy;
		this.offerPrice = offerPrice;
		this.isComplete = isComplete;
		this.quantity = quantity;
		this.timeStamp = timeStamp;
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
	public int getItemsId() {
		return itemsId;
	}
	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public int getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "OfferDTO [offersId=" + offersId + ", membersId=" + membersId + ", itemsId=" + itemsId + ", buy=" + buy
				+ ", offerPrice=" + offerPrice + ", isComplete=" + isComplete + ", quantity=" + quantity
				+ ", timeStamp=" + timeStamp + "]";
	}
	

}
