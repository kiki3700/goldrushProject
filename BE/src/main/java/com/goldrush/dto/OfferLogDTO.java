package com.goldrush.dto;

import java.sql.Timestamp;

public class OfferLogDTO {

	private int offersId;
	private int membersId;
	private int itemsId;
	private String code;
	private boolean buy;
	private int offerPrice;
	private boolean isComplete;
	private int quantity;
	private int quantityBalance;
	private Timestamp timeStamp;
	
	
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
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


	public int getQuantityBalance() {
		return quantityBalance;
	}


	public void setQuantityBalance(int quantityBalance) {
		this.quantityBalance = quantityBalance;
	}


	public Timestamp getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Override
	public String toString() {
		return "OfferLogDTO [offersId=" + offersId + ", membersId=" + membersId + ", itemsId=" + itemsId + ", code="
				+ code + ", buy=" + buy + ", offerPrice=" + offerPrice + ", isComplete=" + isComplete + ", quantity="
				+ quantity + ", quantityBalance=" + quantityBalance + ", timeStamp=" + timeStamp + "]";
	}
}
