package com.goldrush.dto;

public class InventoryDTO {
	private int inventoriesId;
	private int membersId;
	private int itemsId;
	private int quantity;
	private int averagePrice;
	
	
	public InventoryDTO() {
		super();
	}


	public int getInventoriesId() {
		return inventoriesId;
	}


	public void setInventoriesId(int inventoriesId) {
		this.inventoriesId = inventoriesId;
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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return averagePrice;
	}


	public void setPrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}


	@Override
	public String toString() {
		return "InventoriesDTO [inventoriesId=" + inventoriesId + ", membersId=" + membersId + ", itemsId=" + itemsId
				+ ", quantity=" + quantity + ", averagePrice=" + averagePrice + "]";
	}
}
