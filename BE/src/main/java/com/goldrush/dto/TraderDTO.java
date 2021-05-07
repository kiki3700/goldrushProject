package com.goldrush.dto;

public class TraderDTO {
	private int membersId;
	private int price;
	private int quantity;
	private int itemsId;
	private boolean buy;
	
	public TraderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TraderDTO(int membersId, int price, int quantity, int itemsId, boolean buy) {
		super();
		this.membersId = membersId;
		this.price = price;
		this.quantity = quantity;
		this.itemsId = itemsId;
		this.buy = buy;
	}
	
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
	@Override
	public String toString() {
		return "TraderDTO [membersId=" + membersId + ", price=" + price + ", quantity=" + quantity + ", itemsId="
				+ itemsId + ", buy=" + buy + "]";
	}
	
}
