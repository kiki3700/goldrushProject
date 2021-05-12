package com.goldrush.dto;

public class TraderDTO {
	private int membersId;
	private int price;
	private int quantity;
	private int itemsId;
	private boolean buy;
	private int partnersId;
	private int offersId;
	
	public int getMembersId() {
		return membersId;
	}
	public void setMembersId(int membersId) {
		this.membersId = membersId;
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
	public int getPartnersId() {
		return partnersId;
	}
	public void setPartnersId(int partnersId) {
		this.partnersId = partnersId;
	}
	public int getOffersId() {
		return offersId;
	}
	public void setOffersId(int offersId) {
		this.offersId = offersId;
	}
	@Override
	public String toString() {
		return "TraderDTO [membersId=" + membersId + ", price=" + price + ", quantity=" + quantity + ", itemsId="
				+ itemsId + ", buy=" + buy + ", partnersId=" + partnersId + ", offersId=" + offersId + "]";
	}
	
	
}
